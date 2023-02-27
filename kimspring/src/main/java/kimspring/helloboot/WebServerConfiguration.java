package kimspring.helloboot;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {
	@Bean
	ServletWebServerFactory customServletWebServerFactory() {
		UndertowServletWebServerFactory serverFactory = 
				new UndertowServletWebServerFactory();
		serverFactory.setPort(9090);
		return serverFactory;
	}
}
