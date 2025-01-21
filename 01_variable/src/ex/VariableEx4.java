package ex;

public class VariableEx4 {

	public static void main(String[] args) {
		// constant

		final double PI = 3.141592;
		final int NATIONAL_CODE = 82;

		// 오류발생 대입불가
		// NATIONAL_CODE =1;

		final int TEMP;
		TEMP = 100;
		System.out.println("[상수확인]");

		int r = 5;

		System.out.println("원의 둘레 : " + 2 * PI * r);
		System.out.println("원의 넓이 : " + PI * r * r);

		System.out.println("NATIONAL CODE : " + NATIONAL_CODE);
		System.out.println("TEMP : " + TEMP);

		
		System.out.println("------overflow------");
		
		int num = Integer.MAX_VALUE;
		num++;
		
		System.out.println("num + 1 = " + num);
		num--;
		System.out.println("num - 1 = " + num);
		
	}

}
