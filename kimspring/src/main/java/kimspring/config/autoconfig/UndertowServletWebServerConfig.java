package kimspring.config.autoconfig;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import kimspring.config.ConditionalMyOnClass;
import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("io.undertow.Undertow")
public class UndertowServletWebServerConfig {
    @Bean("undertowServletWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new UndertowServletWebServerFactory();
    }
}
