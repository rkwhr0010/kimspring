package kimspring.helloboot;
//스프링 없던 시절이라 생각하고 시작(어노테이션제거)

public class HelloController {
	public String hello (String name) {
		return "Hello "+name;
	}
}
