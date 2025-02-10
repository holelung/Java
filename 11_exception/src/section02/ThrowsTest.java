package section02;

import java.io.IOException;



/* throws : 메서드에서 발생한 예외를
 *  				메서드 호출부로 던지는 키워
 * 
 * [throws 사용 이유]
 * 1) 경고의 의미
 * 	
 * 2) 예외 처리를 한곳에 묶어서 처리하기 위해
 */
public class ThrowsTest {

	public void method1() throws IOException {
		method2();
	}

	public void method2() throws IOException {
		method3();
	}

	public void method3() throws IOException {
		throw new IOException();
	}
	
	
	// -------------------------------------------
	
	/* Unchecked Exception : 
	 * 
	 * 
	 * 
	 * 
	 * Checked Exception :
	 * 
	 */
	
	public void test1() throws IOException {
		// checkedException 강제 발생
		throw new IOException();
		// 컴파일 에러 발생 -> 예외처리 후 해결
		
	}
	
	// throws 구문을 작성하지 않아도
	// UncheckedException 발생 시 자동으로 호출부로 던짐!!
	// -> 자바라는 언어의 설계 철학(개발자가 덜 신경쓰고 쉽게 사용)
	// -> 컴파일러가 throws RuntimeException 자동 추가
	public void test2() {
		// UnckeckedException 강제 발생
		// throw new RuntimeException();
		// -> 컴파일 에러 발생 안함
		int num = 3/0; // ArithmeticException 발생
		// 컴파일 에러 발생 X -> 예외 처리 강제되지 않음
		
	}
	
	
	
	
	
}
