package kimspring.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import kimspring.config.ConditionalMyOnClass;
import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("io.undertow.Undertow")
public class UndertowServletWebServerConfig {
    @Bean("undertowServletWebServerFactory")
    @ConditionalOnMissingBean
    ServletWebServerFactory servletWebServerFactory(Environment env) {
    	UndertowServletWebServerFactory serverFactory = new UndertowServletWebServerFactory();
    	serverFactory.setPort(Integer.valueOf(env.getProperty("server.port")));
    	serverFactory.setContextPath(env.getProperty("server.servlet.context-path"));
        return serverFactory;
    }
}
