package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
	static HelloController helloController;
	
	@BeforeEach
	void init(){
		helloController = new HelloController(name -> name);
	}
	
	@Test
	void helloController() {
		HelloController helloController = HelloControllerTest.helloController;
		String hello = helloController.hello("Test");
		assertThat(hello).isEqualTo("Test");
	}
	@Test
	void helloController2() {
		HelloController helloController = HelloControllerTest.helloController;
		assertThatThrownBy(()->helloController.hello(null)).isInstanceOf(IllegalArgumentException.class);
	}
	@Test
	void helloController3() {
		HelloController helloController = HelloControllerTest.helloController;
		assertThatThrownBy(()->helloController.hello("")).isInstanceOf(IllegalArgumentException.class);
	}
	@Test
	void helloController4() {
		HelloController helloController = HelloControllerTest.helloController;
		assertThatThrownBy(()->helloController.hello("   ")).isInstanceOf(IllegalArgumentException.class);
	}
}
