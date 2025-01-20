package ex;

public class VariableEx2 {

	// main method : 자바 실행구문
	public static void main(String[] args) {

		System.out.println("[자동 형변환 예시1]");

		int a1 = 12;
		double b1 = 1.3;
		double result = a1 + b1;

		System.out.println(a1 + " + " + b1 + " = " + result);

		System.out.println("[자동 형변환 예시2]");
		char ch2 = 'A';
		int num2 = 100;
		int result2 = ch2 + num2;

		System.out.println(ch2 + " + " + num2 + " = " + result2);

		System.out.println("[자동 형변환 예시3]");
		// 값의 범위로 생각 x, 컴퓨터 값 처리 원칙 생각 O

		int a3 = 3;
		int b3 = 2;

		int result3 = a3 / b3;
		System.out.println("result3 : " + result3);

		// 자동 형변환이 되지 않는 경우
		// "강제 형변환"을 이용
		System.out.println("-------------------");
		System.out.println("[자동 형변환 예시4]");

		int a4 = 100;
		double b4 = 23.4;
		int result4 = (int) (a4 + b4);
		System.out.println("result4 = " + result4);
	}

}
