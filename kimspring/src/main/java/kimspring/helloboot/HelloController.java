package kimspring.helloboot;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 디스패처 서블릿은 빈으로 등록된 객체 중 RequestMapping을 가진 빈을 탐색해
 * 매핑 테이블을 만들어, 사용한다. 이때 클래스 레벨에 RequestMapping을 탐색해
 * 만들기 때문에 메서드 레벨에만 붙이면 매핑 테이블에 등록이 안된다.
 */
@RestController
//@ResponseBody
//@Component
//@RequestMapping
public class HelloController {
	private final HelloService helloService;
	
	public HelloController(HelloService helloService) {
		super();
		this.helloService = helloService;
	}
	@GetMapping("/hello")
	public String hello (String name) {
		return helloService.sayHello(Objects.requireNonNull(name));
	}
	@PostMapping("/hello")
	public String hello2 (String name) {
		return helloService.sayHello("POST"+Objects.requireNonNull(name));
	}
}
