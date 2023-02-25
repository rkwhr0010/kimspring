package kimspring.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
	// 이 메서드 인자로 올수 있는 클래스는 @Configuration, @ComponentScan,
	// 서블릿서버팩토리빈, 디시패처서블릿빈 구성정보를 가진 클래스만 올 수 있다.
	public static void run(Class<?> applicationClass, String... args) {
		// 스프링 컨테이너
		AnnotationConfigServletWebApplicationContext applicationContext = 
				new AnnotationConfigServletWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//					dispatcherServlet.setApplicationContext(this);
				// 스프링 컨테이너가 자동으로 등록해준다. , ApplicationContextAware 이용

				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet", dispatcherServlet).addMapping("/*");
				});
				webServer.start();
			}
		};
		applicationContext.register(applicationClass);
		applicationContext.refresh();
	}
}
