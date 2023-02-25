package kimspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService{
	private final HelloService helloService;

	public HelloDecorator(HelloService helloService) {
		super();
		this.helloService = helloService;
	}

	@Override
	public String sayHello(String name) {
		return "*"+this.helloService.sayHello(name)+"*";
	}

}
