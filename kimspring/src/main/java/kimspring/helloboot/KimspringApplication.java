package kimspring.helloboot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class KimspringApplication {

	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext ->{
			servletContext.addServlet("frontController", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp)
						throws ServletException, IOException {
					// 중앙화 됐기에 모든 요청은 이 서블릿을 커친다.
					// 인증, 보안, 다국어처리, 공통 기능을 넣기 용이 
					
					// 모든 URI를 다 받기에 별도로 분기처리가 필요하다.
					if(req.getRequestURI().equals("/hello")&&req.getMethod().equals(HttpMethod.GET.name())) {
						resp.setStatus(HttpStatus.OK.value());	//상태코드
//						resp.addHeader("Content-Type",MediaType.TEXT_PLAIN_VALUE);
						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);//헤더(주로 미디어타입)
						//로직이라고 가정
						String name = req.getParameter("name");
						
						resp.getWriter().println("Hello SpringBoot "+ name);
						
					}else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*"); // 모든 요청을 처리
		});
		webServer.start();
	}
}
