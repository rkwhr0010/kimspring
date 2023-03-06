package kimspring.helloboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {
	
	private final HelloRepository helloRepository;
	
	public SimpleHelloService(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}



	public String sayHello(String name) {
		helloRepository.increaseCount(name); 
		return "Hello " + name;
	}



	@Override
	public int countOf(String name) {
		return helloRepository.findHello(name).getCount();
	}
}
