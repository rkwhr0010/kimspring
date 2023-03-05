package kimspring.helloboot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//스프링 컨테이너 구동
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = KimspringApplication.class)
//프로퍼티 파일을 스프링부트만의 확장 기능이다. 따라서 위 설정만으론 설정파일을 읽을 수 없다.
//그래서 추가로 아래와 같은 설정이 필요하다.
@TestPropertySource("classpath:/application.properties")
public @interface HelloBootTest {}
