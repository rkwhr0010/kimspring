package kimspring.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import kimspring.config.autoconfig.DispatcherServletConfig;
import kimspring.config.autoconfig.TomcatServletWebServerConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServletConfig.class, TomcatServletWebServerConfig.class})
public @interface MyEnableAutoConfiguration {

}
