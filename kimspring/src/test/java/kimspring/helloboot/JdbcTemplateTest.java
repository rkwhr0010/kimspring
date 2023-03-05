package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@HelloBootTest
@Transactional
//@Rollback(false)
public class JdbcTemplateTest {
	@Autowired JdbcTemplate jdbcTemplate;
	@BeforeEach
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}
	@Test
	void insertAndQuery() {
		jdbcTemplate.update("insert into hello values(?,?)","Kim",3);
		jdbcTemplate.update("insert into hello values(?,?)","Spring",1);
		
		Long count = jdbcTemplate.queryForObject("select count(1) from member", Long.class);
		assertThat(count).isEqualTo(2);
	}
	@Test
	void insertAndQuery2() {
		jdbcTemplate.update("insert into hello values(?,?)","Kim",3);
		jdbcTemplate.update("insert into hello values(?,?)","Spring",1);
		
		Long count = jdbcTemplate.queryForObject("select count(1) from member", Long.class);
		assertThat(count).isEqualTo(2);
	}
}
