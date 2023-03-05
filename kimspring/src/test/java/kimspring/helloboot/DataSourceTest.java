package kimspring.helloboot;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@HelloBootTest
//DB 관련 테스트는 테스트 실행 후 그 결과가 그 다음 테스트에 영향을 미칠 수 있다.
//그래서 트랜잭션 어노테이션을 붙여 롤백시켜 테스트 실행 전으로 돌린다.
@Transactional
public class DataSourceTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	void connect() throws SQLException{
		Connection connection = dataSource.getConnection();
		connection.close();
	}
	
}
