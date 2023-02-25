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
	
	public static void main(String[] args) {
		//스프링 컨테이너
		AnnotationConfigServletWebApplicationContext applicationContext = 
				new AnnotationConfigServletWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();
				
				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
				
//				dispatcherServlet.setApplicationContext(this);
				//스프링 컨테이너가 자동으로 등록해준다. , ApplicationContextAware 이용
				
				WebServer webServer = serverFactory.getWebServer(servletContext ->{
					servletContext.addServlet("dispatcherServlet", dispatcherServlet)
						.addMapping("/*"); 
				});
				webServer.start();
			}
		};
		applicationContext.register(KimspringApplication.class);
		applicationContext.refresh();
		
	}
}
