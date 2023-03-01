package kimspring.helloboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

//@TestPropertySource({"classpath:application.properties"})
//@SpringBootTest(classes = KimspringApplication.class)
public class HelloApiTest {
	
	@Value("${server.port}")
	int port;
	@Value("${server.servlet.context-path}")
	String contextPath;
	
//	@Test
	void propertyTest() {
		assertThat(port).isNotEqualTo(0);
		assertThat(contextPath).isNotBlank();
		
	}
	
	@Test
	void helloApi() {
		ResponseEntity<String> entity = 
				new TestRestTemplate().getForEntity("http://localhost:"+9090+"/app"+"/hello?name={name}", String.class,"boot");
		//HTTP 3요소 검증, 상태코드,헤더,바디
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
		assertThat(entity.getBody()).isEqualTo("*Hello boot*");
	}
	@Test
	void helloApi2() {
		ResponseEntity<String> entity = 
				new TestRestTemplate().getForEntity("http://localhost:"+9090+"/app"+"/hello?name=", String.class);
		//실무라면 500에러는 400번대로 변경했을 것이다. 하지만 실습에선 그냥 뒀다.
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
