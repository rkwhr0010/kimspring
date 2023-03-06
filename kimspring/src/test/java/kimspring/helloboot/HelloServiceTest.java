package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloServiceTest {
	@Test
	void simpleHelloService() {
		SimpleHelloService simpleHelloService = new SimpleHelloService(helloRepositoryStub);
		String sayHello = simpleHelloService.sayHello("boot");
		
		assertThat(sayHello).isEqualTo("Hello boot");
		
	}

	private HelloRepository helloRepositoryStub=new HelloRepository() {
		@Override
		public void increaseCount(String name) {
		}
		@Override
		public Hello findHello(String name) {
			return null;
		}
	};
	
	@Test
	void helloDecorator() {
		HelloDecorator helloDecorator = new HelloDecorator(name -> name);
		String sayHello = helloDecorator.sayHello("Test");
		
		assertThat(sayHello).isEqualTo("*Test*");
		
	}
	
}
