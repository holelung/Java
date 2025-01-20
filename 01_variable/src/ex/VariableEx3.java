package ex;

public class VariableEx3 {

	public static void main(String[] args) {

		System.out.println("[강제 형변환 예제 1]");
		int num1 = 290;
		byte result1 = (byte) num1;
		System.out.println(result1);

		System.out.println("-----------------------------------");
		System.out.println("[강제 형변환 예제 2 - 데이터 손실]");

		double num2 = 123.999;
		int result2 = (int) num2;
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);

		System.out.println("---------------------------------------------");
		System.out.println("[강제 형변환 예제 3 - 데이터 손실 의도적 사용]");

		// 난수를 정수 형태로 반환 받기
		// 1 ~ 10 사이 정수형 난수
		// JS : Math.floor(Math.random() * 10 +1);
		// Java : (int)(Math.random() * 10 + 1)

		// 0.0 이상 1.0 미만 double형 난수 반환
		for (int i = 0; i < 5; i++) {
			int randomNumber = (int) (Math.random() * 10 + 1);
			System.out.println("randomNumber : " + randomNumber);
		}

		System.out.println("---------------------------------------");
		System.out.println("[의도적으로 자료형을 변환1]");

		int a3 = 5;
		int b3 = 2;
		// a3/ b3 = 2.5 가 나오게 하고싶다.
		System.out.println((double)a3 / b3);

		
		System.out.println("---------------------------------------");
		System.out.println("[의도적으로 자료형을 변환2]");
		
		System.out.println(" 문자 (char) <-> 유니코드(int)");
		System.out.println("A의 유니코드 번호 : " + (int)'A');
		System.out.println("A뒤의 10번째 문자 : " + (char)('A'+10));
		
	}

}
