package kimspring.helloboot;

import javax.annotation.PostConstruct;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class KimspringApplication {
	
	private final JdbcTemplate jdbcTemplate;
	
	
	
	public KimspringApplication(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}
		
	
	@Bean
	ApplicationRunner applicationRunner(Environment env) {
		return args -> {};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KimspringApplication.class, args);
	}
	
}
