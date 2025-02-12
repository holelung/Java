package section02;

import java.util.HashSet;
import java.util.Set;
import java.util.function.*;

public class FunctionTest {
	public static void main(String[] args) {
		/* Function 계열
		 * - 매개 변수를 받아서 다른 타입으로 변환(가공)하여 반환
		 * 	 함수형 인터페이스
		 * 
		 * - applyXXX() 메서드 제공
		 * 
		 * 
		 */
		
		/* Function<T, R> : 매개변수 T 전달, R 타입으로 반환 */
		Function<String, Integer> strLength = str -> str.length();
		System.out.println("짱구는 5짤 의 문자열 길이는 : "+ strLength.apply("짱구는 5짤"));
		
		/* BiFunction<T, U, R> : T와 U를 전달 받아 R형태로 반환*/
		BiFunction<String, Integer, String> formatAge = (name, age) -> name + "은/는 " + age + "살 입니다.";
		System.out.println(formatAge.apply("홍길동", 18));
		BiFunction<Integer, Integer, Double> divTwoNumber = (a, b) -> (double)a/b;
		System.out.printf("%d / %d = %.2f\n", 3, 2, divTwoNumber.apply(3, 2));
		System.out.printf("%d / %d = %.2f\n", 34, 4, divTwoNumber.apply(34, 4));
		
		/* IntToDoubleFunction : int 를 받아서 double로 반환 */
		IntToDoubleFunction randomNumber = range -> Math.random() * range; // 0이상 range 미만 수 반환
		Set<Double> set = new HashSet<>();
		while(set.size() < 10) { // set에 저장된 객체 수 10 미만이면 반복
			set.add(randomNumber.applyAsDouble(5));	
		}
		// 컬렉션(Set) + 람다식
		set.forEach( r -> System.out.println(r));
		
		
	}
}
