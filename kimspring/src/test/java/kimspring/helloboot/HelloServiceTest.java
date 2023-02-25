package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloServiceTest {
	@Test
	void simpleHelloService() {
		SimpleHelloService simpleHelloService = new SimpleHelloService();
		String sayHello = simpleHelloService.sayHello("boot");
		
		assertThat(sayHello).isEqualTo("Hello boot");
		
	}
	
	@Test
	void helloDecorator() {
		HelloDecorator helloDecorator = new HelloDecorator(name -> name);
		String sayHello = helloDecorator.sayHello("Test");
		
		assertThat(sayHello).isEqualTo("*Test*");
		
	}
	
}
