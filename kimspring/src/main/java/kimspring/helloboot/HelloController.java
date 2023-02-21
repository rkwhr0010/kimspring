package kimspring.helloboot;

import java.util.Objects;

public class HelloController {
	//생성자 주입을 받을 때 가급적 private final을 생활화하자
	private final HelloService helloService;
	//스프링 컨테이너가 해당 인터페이스 타입을 구현한 클래스가 있으면 자동으로 의존 주입해준다.
	public HelloController(HelloService helloService) {
		super();
		this.helloService = helloService;
	}
	public String hello (String name) {
		//컨트롤러는 데이터 검증만 수행
//		return "Hello "+name;
		//로직을 서비스로 위임
		return helloService.sayHello(Objects.requireNonNull(name));
	}
}
