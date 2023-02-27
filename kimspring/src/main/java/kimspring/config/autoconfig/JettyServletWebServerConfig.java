package kimspring.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@Conditional(JettyServletWebServerConfig.JettyCondition.class)
public class JettyServletWebServerConfig {
	//명시적으로 이름을 안주면 메서드이름으로 등록된다.
    @Bean("jettyServletWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

    static class JettyCondition implements Condition{
    	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    		return true;
    	}
    }
}
