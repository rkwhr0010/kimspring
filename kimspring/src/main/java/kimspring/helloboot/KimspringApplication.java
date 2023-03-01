package kimspring.helloboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import kimspring.config.MySpringBootApplication;

@MySpringBootApplication
public class KimspringApplication {
	
	@Bean
	ApplicationRunner applicationRunner(Environment env) {
		return args -> {};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KimspringApplication.class, args);
	}
	
}
