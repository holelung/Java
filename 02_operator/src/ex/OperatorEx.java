package ex;

import java.util.Scanner;

/**
 * 예제 기능(메서드)를 제공하는 클래스
 */
public class OperatorEx {

	// 테스트용 메서드1(메서드 = class 가 가지고 있는 함수)
	public void test1() {
		System.out.println("test1() 호출됨");
	}

	// 테스트용 메서드2
	public void test2() {
		System.out.println("test2() 호출됨!");
	}

	/**
	 * DOC 주석은 내부에 HTML 표기법 작성 가능<br>
	 * 입력 받은 두 정수의 산술 연산결과 출력하기
	 * 
	 * <pre>
	 * [실행화면]
	 * 정수입력 1 : 10
	 * 정수입력 2 : 3 
	 * 
	 * 10 + 3 = 13
	 * 10 - 3 = 7
	 * 10 * 3 = 30
	 * 10 / 3 = 3
	 * 10 % 3 = 1
	 * </pre>
	 */
	public void method1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 1 : ");
		long num1 = sc.nextLong();
		System.out.print("정수입력 2 : ");
		long num2 = sc.nextLong();

		sc.close();
		System.out.println();

		System.out.printf("%d + %d = %d \n", num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d \n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d \n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d \n", num1, num2, num1 / num2);
		System.out.printf("%d %% %d = %d \n", num1, num2, num1 % num2);

	}

	/**
	 * <h3>입력 받은 정수가 3의 배수가 맞는 지 확인</h3>
	 * 
	 * <pre>
	 * [실행화면]
	 * 정수 입력 : 6
	 * 6은 3의 배수가 맞습니다.
	 * 
	 * (틀린경우)
	 * 정수 입력 : 7
	 * 7은 3의 배수가 아닙니다.
	 * </pre>
	 */
	public void method2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		long num1 = sc.nextLong();

		String result = (num1 % 3 == 0) ? "맞습니다." : "아닙니다.";

		System.out.printf("%d은 3의 배수가 %s", num1, result);

	}

	/**
	 * <h3>입력된 나이에 따라 "어린이","청소년","성인" 구분하기</h3>
	 * 
	 * <pre>
	 * 13세 이하					 "어린이"
	 * 14세 이상 19세 이하 "청소년"
	 * 20세 이상 					 "성인"
	 * </pre>
	 */
	public void method3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("나이 입력 : ");
		int age = sc.nextInt();

		String result = age <= 13 ? "어린이" : (age < 20 ? "청소년" : "성인");
		System.out.printf("%d세는 %s입니다.", age, result);

	}

}
