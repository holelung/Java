package loop.service;

import java.util.Scanner;

public class LoopService1 {

	// field
	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		System.out.println("6. method6()");
		System.out.println("7. method7()");
		System.out.println("8. method8()");
		

		System.out.print("실행할 메서드 번호 입력 >> ");
		int input = sc.nextInt();

		System.out.println("\n-------------------------------------\n");
		switch (input) {
		case 1:
			method1();
			break;
		case 2:
			method2();
			break;
		case 3:
			method3();
			break;
		case 4:
			method4();
			break;
		case 5:
			method5();
			break;
		case 6:
			method6();
			break;
		case 7:
			method7();
			break;
		case 8:
			method8();
			break;
		default:
			System.out.println("없는 번호 입력함");
		}

	}

	/**
	 * for 문을 이용해서 1~10까지 세로로 출력하기
	 */
	public void method1() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	/**
	 * 987654321 출력하기
	 */
	public void method2() {
		for (int i = 9; i > 0; i--) {
			System.out.print(i);
		}
		System.out.println("\n---------------------");
		for (int i = 0; i < 9; i++) {
			System.out.print(9 - i);

		}
	}

	/**
	 * 두 정수를 입력받아 두 정수 사이 모든 정수를 출력 (무조건 첫 번째 입력이 작은수)
	 * 
	 * <pre>
	 * 첫 번째 정수 입력 : 5
	 * 두 번째 정수 입력 : 12
	 * 5 6 7 8 9 10 11 12
	 * </pre>
	 */
	public void method3() {
		System.out.print("첫 번째 정수 입력 : ");
		int input1 = sc.nextInt();

		System.out.print("두 번째 정수 입력 : ");
		int input2 = sc.nextInt();

		if (input1 > input2) {
			int sum = input1;
			input1 = input2;
			input2 = sum;
		}

		sc.close();

		for (int i = input1; i <= input2; i++) {
			System.out.print(i + " ");
		}

	}

	/**
	 * 입력된 두 정수 사이의 모든 정수 출력
	 * <ul>
	 * <li>입력1이 입력2보다 작은경우 : 1234~ 증가하며 출력</li>
	 * <li>입력1이 입력2보다 큰 경우 : 9876~ 감소하며 출력</li>
	 * </ul>
	 */
	public void method4() {
		System.out.print("첫 번째 정수 입력 : ");
		int input1 = sc.nextInt();

		System.out.print("두 번째 정수 입력 : ");
		int input2 = sc.nextInt();

		// 방법 1
		if (input1 > input2) {
			for (int i = input1; i >= input2; i--) {
				System.out.print(i + " ");
			}
			return;
		}
		for (int i = input1; i <= input2; i++) {
			System.out.print(i + " ");
		}
		
		// 방법 2
		for(int i = 0; i< Math.abs(input1-input2); i++) {
			if(input1>input2) {
				System.out.print(input1-i + " ");
			}else {
				System.out.print(input1+i + " ");
			}
		}
	}
	
	/**
	 * 두 정수를 입력 받아
	 * 작은 수 부터 큰 수 까지 1씩 증가하며 출력
	 * <pre>
	 * [실행화면]
	 * 입력 1 : 3
	 * 입력 2 : 6
	 * 3 4 5 6
	 * 
	 * 입력 1: 7
	 * 입력 2: 2
	 * 2 3 4 5 6 7
	 * 
	 * </pre>
	 */
	public void method5() {
		System.out.print("입력 1 : ");
		int input1 = sc.nextInt();

		System.out.print("입력 2 : ");
		int input2 = sc.nextInt();

		if (input1 > input2) {
			int temp = input1;
			input1 = input2;
			input2 = temp;
		}

		sc.close();

		
		for (int i = input1; i <= input2; i++) {
			System.out.print(i + " ");
		}

	}
	
	
	/**
	 * 1-100 정수 중에
	 * 입력 받은 정수의 배수가 몇개, 배수의 합
	 */
	public void method6() {
		System.out.print("1-100 사이의 정수 입력 : ");
		int num = sc.nextInt();
		int count = 100/num;
		int sum = 0;
		
		for(int i =1; i<=count; i++) {
			sum += i*num;
		}
		System.out.printf("%d의 배수는 %d개, 배수의 합 : %d", num, count, sum);
		
	}
	
	/**
	 * 입력 받은 단 출력하기(구구단)
	 */
	public void method7() {
		System.out.print("1-9 사이의 정수 입력 : ");
		int idx = sc.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %2d\n", idx, i, idx*i);
		}
		
	}
	
	/**
	 * 두 정수 사이의 구구단 전부출력
	 * <pre>
	 * 시작 단 : 3
	 * 종료 단 : 5
	 * 
	 * [3단]
	 * ...
	 * 
	 * [4단]
	 * 4 x 1 = 4
	 * ...
	 * 
	 * [5단]
	 * ...
	 * </pre>
	 */
	public void method8() {
		System.out.print("시작 단 : ");
		int input1 = sc.nextInt();

		System.out.print("종료 단 : ");
		int input2 = sc.nextInt();
		
		for(int i=input1; i<=input2;i++) {
			System.out.printf("\n[%d단]\n", i);
			for(int j=1; j<=9; j++) {
				System.out.printf("%d x %d = %2d\n", i, j, j*i);
			}
		}
		
	}
}
