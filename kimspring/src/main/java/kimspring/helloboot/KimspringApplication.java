package kimspring.helloboot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class KimspringApplication {

	public static void main(String[] args) {
		//스프링 컨테이너
		//객체의 생성과 소멸, 일련의 생애주기를 관리한다.
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		applicationContext.registerBean(HelloController.class);
		//모든 구성 정보 설정 등을 다 등록 후 이를 이용해 초기화하는 작업이 아래 메서드
		applicationContext.refresh();
		
		/* 스프링 컨테이너는 주로 클래스 메타 정보를 이용해 객체를 생성하는 방식을 취한다.
		 * 물론 객체를 직접 생성해 등록도 가능하다.
		 */
		
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext ->{
			//이제 스프링 컨테이너의 빈으로 등록된다.
//			HelloController helloController = new HelloController();
			//스프링 컨테이너에서 빈 정보를 가져온다. 이제 객체를 어떻게 생성할지는 신경 안쓴다. 단순히 필요하니까 가져다 쓴다.
			HelloController helloController = applicationContext.getBean(HelloController.class);
			
			servletContext.addServlet("frontController", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp)
						throws ServletException, IOException {
					// 중앙화 됐기에 모든 요청은 이 서블릿을 커친다.
					// 인증, 보안, 다국어처리, 공통 기능을 넣기 용이 
					
					// HTTP요청 매핑
					if(req.getRequestURI().equals("/hello")&&req.getMethod().equals(HttpMethod.GET.name())) {
						
						//웹 요청에서 정보를 추출하고, 의미있는 오브젝트에 담아서 전달하는 작업을 바인딩이라 한다.
						String name = req.getParameter("name");
						String ret = helloController.hello(name);
						
						//3가지 요소(상태 코드, 헤더, 바디)
						resp.setStatus(HttpStatus.OK.value());	//상태코드
						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);//헤더
						resp.getWriter().println(ret);//바디
						
					}else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*"); // 모든 요청을 처리
		});
		webServer.start();
	}
}
