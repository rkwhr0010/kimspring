package kimspring.config.autoconfig;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import kimspring.config.MyAutoConfiguration;

@MyAutoConfiguration
@Conditional(UndertowServletWebServerConfig.UndertowCondition.class)
public class UndertowServletWebServerConfig {
    @Bean("undertowServletWebServerFactory")
    ServletWebServerFactory servletWebServerFactory() {
        return new UndertowServletWebServerFactory();
    }
    static class UndertowCondition implements Condition{
    	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    		return ClassUtils.isPresent("io.undertow.Undertow", context.getClassLoader());
    	}
    }
}
