package common;

import java.util.Scanner;

public class ScannerEx1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("입력 받은 num1 : " + num1);
		
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("입력 받은 num2 : " + num2);
		
		sc.close();
		System.out.printf("두 수의 합 : %d", num1+num2);
	}
}
