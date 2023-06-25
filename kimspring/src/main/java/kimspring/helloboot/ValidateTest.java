package kimspring.helloboot;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.util.ObjectUtils;

public class ValidateTest {
	public static void main(String[] args) {
//		System.out.println(ObjectUtils.isEmpty(""));
//		System.out.println(ObjectUtils.isEmpty("0"));
//		System.out.println(ObjectUtils.isEmpty(Arrays.asList("")));
//		System.out.println(ObjectUtils.isEmpty(null));
		
		System.out.println(Objects.equals(new String("123"),new String("123")));
		System.out.println(Objects.equals(new String("123"),String.valueOf("123")));
		System.out.println(
				Stream.<String>of("123","","1")
					.anyMatch(ObjectUtils::isEmpty)
				);
		
		
	}
}
