package loop.service;

import java.util.Scanner;

public class LoopService2 {
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("[LoopService22222222]");
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		
		System.out.print("번호 입력 >> ");
		int input = sc.nextInt();
		
		switch(input){
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
			default : System.out.println("잘못 입력");
		}
	}
	
	/** 다음 모양 출력하기 
	 * <pre>
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 * (3,0) (3,1) (3,2)
	 * </pre>
	 */
	public void method1() {
		for(int i=0; i<4; i++) { // row
			for(int j=0; j<3; j++) { // col
				System.out.printf("(%d, %d) ", i, j);
			}
			System.out.println("");
		}
	}
	
	/**
	 * 1-20 까지 출력
	 * 단, 입력 받은 수에서 반복 멈추기
	 */
	public void method2() {
		System.out.print("stop number : ");
		int stop = sc.nextInt();
		
		for(int i=1 ; i<=20;i++) {
			System.out.print(i+" ");
			if(stop == i) {
				break;
			}
		}
	}
	
	/**
	 * 1-20 출
	 * 단, 입력 받은 수의 배수는 출력 x
	 */
	public void method3() {
		System.out.print("skip number : ");
		int skip = sc.nextInt();
		
		for(int i=1;i<=20;i++) {
			if(i%skip==0) {
				System.out.print(" ");
				continue;
			}
			System.out.print(i+" ");
		}
	}
	
	/**
	 * sum input numbers
	 * until input==0
	 */
	public void method4() {
		int sum = 0;
		int input = 1;
		
		while(input != 0) {
			System.out.print("input number : ");
			input = sc.nextInt();
			sum += input;
		}
		System.out.println("sum = "+sum);
	}
	
	/* do while 
	 * -while 문의 조건식이 마지막으로 이
	 * 
	 */
	public void method5() {
		int sum = 0;
		int input = 0;
		
		do{
			System.out.print("input number : ");
			input = sc.nextInt();
			sum += input;
		}while(input != 0);
		System.out.println("sum = "+sum);
	}
	
}
