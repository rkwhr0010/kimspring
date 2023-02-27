package kimspring.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@Conditional(TomcatServletWebServerConfig.TomcatCondition.class)
public class TomcatServletWebServerConfig {
	@Bean("tomcatServletWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
    static class TomcatCondition implements Condition{
    	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    		return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat"
    				, context.getClassLoader());
    	}
    }
}
