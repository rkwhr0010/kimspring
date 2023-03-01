package kimspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import kimspring.config.ConditionalMyOnClass;
import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("io.undertow.Undertow")
public class UndertowServletWebServerConfig {
	
	@Value("${server.port}")
	int port;
	@Value("${server.servlet.context-path}")
	String contextPath;
	
	
    @Bean("undertowServletWebServerFactory")
    @ConditionalOnMissingBean
    ServletWebServerFactory servletWebServerFactory() {
    	UndertowServletWebServerFactory serverFactory = new UndertowServletWebServerFactory();
    	serverFactory.setPort(port);
    	serverFactory.setContextPath(contextPath);
        return serverFactory;
    }
}
