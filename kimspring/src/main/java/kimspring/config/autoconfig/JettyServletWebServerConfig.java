package kimspring.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import kimspring.config.ConditionalMyOnClass;
import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyServletWebServerConfig {
    @Bean("jettyServletWebServerFactory")
    @ConditionalOnMissingBean
    ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }
}
