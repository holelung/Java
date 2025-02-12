package section02;

import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {
	public static void main(String[] args) {
		/* Operator 계열
		 * - 매개변수와 반환값의 타입이 같은 함수형 인터페이스
		 * - applyXXX() 메소드 제공 
		 */
		
		/* UnaryOperator<T> : T를 전달 받아 T를 반환 */
		UnaryOperator<String> addString = str -> "[" + str + "] 님 반갑습니다.";
		System.out.println(addString.apply("고몽치"));
		
		
		// IntBinaryOperator : int 매개변수 2개 받아 int 반환
		IntBinaryOperator squre = (a,x) -> {
			int result = 1;
			for(int i= 0; i<x; i++) {
				result *= a;
			}
			return result;
		};
		System.out.println("3^10 ==  " + squre.applyAsInt(3,10));
		System.out.println("2^20 ==  " + squre.applyAsInt(2,20));
	}
}
