package kimspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class KimspringApplication {
	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}
	@Bean 
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
	
	//스프링 부트 초기 시작 어플리케이션과 유사해졌다.
	public static void main(String[] args) {
		MySpringApplication.run(KimspringApplication.class, args);
	}
	
}
