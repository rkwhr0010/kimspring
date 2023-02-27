package kimspring.config.autoconfig;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@Conditional(JettyServletWebServerConfig.JettyCondition.class)
public class JettyServletWebServerConfig {
    @Bean("jettyServletWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }
    static class JettyCondition implements Condition{
    	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    		return ClassUtils.isPresent("org.eclipse.jetty.server.Server"
    				, context.getClassLoader());
    	}
    }
}
