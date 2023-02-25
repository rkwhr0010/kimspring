package kimspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
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
	
	/*스프링이 제공하는 run()메서드를 쓴다고 해도 위 두 빈은 반드시 핋요하다. 
	 * 후에 어떻게 제고되는지 알아본다*/
	public static void main(String[] args) {
		SpringApplication.run(KimspringApplication.class, args);
//		MySpringApplication.run(KimspringApplication.class, args);제거 됨
	}
	
}
