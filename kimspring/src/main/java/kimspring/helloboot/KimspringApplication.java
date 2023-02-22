package kimspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class KimspringApplication {
	@Bean
	public HelloController helloController(HelloService helloService) {
		return new HelloController(helloService);
	}
	@Bean
	public HelloService helloService() {
		return new SimpleHelloService();
	}
	public static void main(String[] args) {
		//스프링 컨테이너
		AnnotationConfigServletWebApplicationContext applicationContext = 
				new AnnotationConfigServletWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext ->{
					servletContext.addServlet("dispatcherServlet", 
							new DispatcherServlet(this)
							).addMapping("/*"); 
				});
				webServer.start();
			}
		};
		applicationContext.register(KimspringApplication.class);
//		applicationContext.regisTERBEAN(HELLOCONTROLLER.CLASS);
//		APPLICATIONCONTEXT.REGISTERBEan(SimpleHelloService.class);
		applicationContext.refresh();
		
	}
}
