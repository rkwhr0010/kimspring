package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@HelloBootTest
@Transactional
public class HelloRepositoryTest {
	@Autowired
	HelloRepository helloRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
//	@BeforeEach // 어플리케이션 main에 @PostConstruct에 설정
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}
	
	@Test
	void findHelloFailded() {
		assertThat(helloRepository.findHello("Kim")).isNull();
	}
	
	@Test
	void increaseCount() {
		assertThat(helloRepository.countOf("Kim")).isEqualTo(0);
		
		helloRepository.increaseCount("Kim");
		assertThat(helloRepository.findHello("Kim").getCount()).isEqualTo(1);
		assertThat(helloRepository.countOf("Kim")).isEqualTo(1);
		
		helloRepository.increaseCount("Kim");
		assertThat(helloRepository.countOf("Kim")).isEqualTo(2);
	}
	
	
}
