package section03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodRefTest {

	public static void main(String[] args) {
		
		/* [메소드 참조]
		 * - 이미 존재하는 메서드를 람다식으로 표현할 때 사용하는 축약된 표현 방식
		 * - 람다식이 단순히 메서드를 호출하는 경우에 사용하면 코드를 더욱 간결하게 만들 수 있음
		 * 
		 * 
		 */
		
		// 문자여 ㄹ길이 반환
		String str = "Hello World";
		
		// 방법 1) 람다식 작성
		Function<String, Integer> strLength = (s) -> s.length();
		System.out.printf("%s 의 길이 %d\n", str, strLength.apply(str));
		
		// 방법 2) 메소드 참조 방식
		Function<String, Integer> length = String::length;
		// -> String을 매개변수로 전달하면 String.length() 메서드를 참조해서 실행 후
		//    Integer 값을 반환
		System.out.printf("%s 의 길이 %d\n", str, length.apply(str));
	
		
		
		System.out.println("-------------------------");

		List<String> nameList = new ArrayList<String>();
		
		nameList.add("짱구");
		nameList.add("유리");
		nameList.add("철수");
		nameList.add("맹구");
		nameList.add("훈이");
		
//		Consumer<String> printName = name -> System.out.println(name);
//		nameList.forEach(printName);
		nameList.forEach(name -> System.out.println(name));
		
		System.out.println("---------------------");

		// 메서드 참조
		// nameList 에서 하나씩 꺼낸 값을 
		// System.out.println()에 전달해서 실행한다.
		nameList.forEach(System.out::println);
		
		
		System.out.println("--------------------");
		
		// 함수형 인터페이스 사용
		Function<Integer, Integer> abs = num -> {
			if(num < 0) return num * -1; // 양수로 반환
			return num;
		};
		
		// 메소드 참조 
		Function<Integer, Integer> abs2 = Math::abs;
		
		System.out.println(abs.apply(-2));
		System.out.println(abs2.apply(-34));
		
		
	}
	
}
