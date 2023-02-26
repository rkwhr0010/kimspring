package kimspring.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
	@Test
	void configuration() {
		AnnotationConfigApplicationContext ac =	new AnnotationConfigApplicationContext();
		ac.register(MyConfig.class);
		ac.refresh();
		
		Bean1 bean1 = ac.getBean(Bean1.class);
		Bean2 bean2 = ac.getBean(Bean2.class);
		assertThat(bean1.common).isSameAs(bean2.common);
		ac.close();
	}
	@Test
	void configuration2() {
		AnnotationConfigApplicationContext ac =	new AnnotationConfigApplicationContext();
		ac.register(MyConfig2.class);
		ac.refresh();
		
		Bean1 bean1 = ac.getBean(Bean1.class);
		Bean2 bean2 = ac.getBean(Bean2.class);
		assertThat(bean1.common).isNotSameAs(bean2.common);
		ac.close();
	}
	@Test
	void proxyTest() {
		MyConfigProxy configProxy = new MyConfigProxy();
		Bean1 bean1 = configProxy.bean1();
		Bean2 bean2 = configProxy.bean2();
		assertThat(bean1.common).isSameAs(bean2.common);
	}
	
	
	class MyConfigProxy extends MyConfig{
		//proxyBeanMethods = true 흉내
		private Common common;
		private Bean1 bean1;
		private Bean2 bean2;
		
		Common common() {
			if(Objects.isNull(common)) this.common = super.common(); 
			return this.common;
		}
		Bean1 bean1() {
			if(Objects.isNull(bean1)) this.bean1 = super.bean1(); 
			return this.bean1;
		}
		Bean2 bean2() {
			if(Objects.isNull(bean2)) this.bean2 = super.bean2(); 
			return this.bean2;
		}
	}
	
	
	@Configuration(proxyBeanMethods = true)
	static class MyConfig{
		@Bean
		Common common() {
			return new Common();
		}
		@Bean
		Bean1 bean1() {
			return new Bean1(common());
		}
		@Bean
		Bean2 bean2() {
			return new Bean2(common());
		}
	}
	
	@Configuration(proxyBeanMethods = false)
	static class MyConfig2{
		@Bean
		Common common() {
			return new Common();
		}
		@Bean
		Bean1 bean1() {
			return new Bean1(common());
		}
		@Bean
		Bean2 bean2() {
			return new Bean2(common());
		}
	}
	
	static class Common{	}
	
	static class Bean1{
		public Bean1(Common common) {
			this.common = common;
		}
		Common common;
	}
	static class Bean2{
		public Bean2(Common common) {
			this.common = common;
		}
		Common common;
	}
}
