package kimspring.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class JettyServletWebServerConfig {
	//명시적으로 이름을 안주면 메서드이름으로 등록된다.
    @Bean("jettyServletWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

}
