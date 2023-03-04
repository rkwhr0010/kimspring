package kimspring.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import kimspring.config.ConditionalMyOnClass;
import kimspring.config.EnableMyConfigurationProperties;
import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("io.undertow.Undertow")
@EnableMyConfigurationProperties(ServerProperties.class)
public class UndertowServletWebServerConfig {
	
    @Bean("undertowServletWebServerFactory")
    @ConditionalOnMissingBean
    ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
    	UndertowServletWebServerFactory serverFactory = new UndertowServletWebServerFactory();
    	serverFactory.setPort(properties.getPort());
    	serverFactory.setContextPath(properties.getContextPath());
        return serverFactory;
    }
    
    
}
