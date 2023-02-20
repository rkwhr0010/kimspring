package kimspring.helloboot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class KimspringApplication {

	public static void main(String[] args) {
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext ->{
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp)
						throws ServletException, IOException {
					resp.setStatus(HttpStatus.OK.value());	//상태코드
					
//					resp.addHeader("Content-Type",MediaType.TEXT_PLAIN_VALUE);
					resp.setContentType(MediaType.TEXT_PLAIN_VALUE);//헤더(주로 미디어타입)
					
					resp.getWriter().println("Hello SpringBoot");
					
				}
			}).addMapping("/*"); // 서블릿 매핑
		});
		
		webServer.start();
		
	}
}
