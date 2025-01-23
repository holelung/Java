package loop.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if (input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}

		for (int i = 1; i <= input; i++) {
			System.out.print(i + " ");
		}
	}

	public void practice2() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if (input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}

		for (int i = input; i > 0; i--) {
			System.out.print(i + " ");
		}
	}

	public void practice3() {
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 0;
		if (input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}

		for (int i = 1; i <= input; i++) {
			sum += i;
			if (i == input) {
				System.out.print(i + " = ");
				break;
			}
			System.out.print(i + " + ");
		}
		System.out.print(sum);

	}

	public void practice4() {
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();

		if (num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력하세요.");
			return;
		}

		if (num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}

		for (int i = num1; i <= num2; i++) {
			System.out.print(i + " ");
		}
	}

	public void practice5() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();

		System.out.printf("===== %d단 =====\n", input);
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", input, i, input * i);
		}

	}

	public void practice6() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();

		if(input < 2 ||  input > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
			return;
		}
		
		for (int i = input; i <= 9; i++) {
			System.out.printf("\n===== %d단 =====\n", i);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", i, j, j * i);
			}
		}

	}
	
	
	public void practice7() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=0; i<input; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
	
	public void practice8() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=input; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	
	public void practice9() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1; i<=input; i++) {
			for(int x=0; x<input-i; x++)
				System.out.print(" ");
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}
	
	
	public void practice10() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i=0; i<input; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int i=input-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void practice11() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int i =1; i<=input; i++) {
			for(int j = input-i; j>0; j--) {
				System.out.print(" ");
			}
			for(int x = 0; x<2*i-1; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	
	public void practice12() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i=1; i<=input; i++) {
			if(i==1 || i==input ) {
				for(int j=0; j<input; j++) {
					System.out.print("*");
				}
				System.out.println("");
				continue;
			}
			System.out.print("*");
			for(int j = 0; j<input-2; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println("");
			
		}
		
	}
	
	public void practice13() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int count = 0;
		for(int i=1; i<=input; i++) {
			if(i % 2==0 || i%3==0) {
				System.out.print(i +" ");
			}
			if(i % 6 == 0) {
				count++;
			}
		}
		System.out.println("\ncount : "+count);
	}
	
	
	public void practice14() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		int count = 0;
		if(input<2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		
		for(int i=1; i<=input; i++) {
			if(input%i==0) {
				count++;
			}
		}
		System.out.printf("%s", count==2?"소수입니다.":"소수가 아닙니다.");
	}
	
	
	public void practice15() {
		int input;
		int count = 0;
		
		while(true) {
			System.out.print("숫자 : ");
			input = sc.nextInt();
			if(input<2) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			break;
		}
		
		for(int i=1; i<=input; i++) {
			if(input%i==0) {
				count++;
			}
		}
		System.out.printf("%s", count==2?"소수입니다.":"소수가 아닙니다.");
		
	}
	
	public void practice16() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		int count = 0;
		
		if(input<2) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		for(int i=2; i<=input; i++) {
			int temp=0;
			for(int j=2; j<=i; j++) {
				if(i%j==0) {
					temp++;
				}
			}
			if(temp ==2) {
				System.out.print(i+" ");
				count++;
			}
		}
		System.out.printf("\n2부터 %d까지 소수의 개수는 %d개입니다.", input,count);
		
	}
	
}
