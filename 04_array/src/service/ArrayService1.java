package service;

import java.util.Scanner;

public class ArrayService1 {

	/**
	 * Java 에서 배열 선언, 할당, 초기화 하는 방법
	 */
	public void method1() {
		// 배열 선언 : 배열을 참조할 변수 생
		int[] arr;

		// 배열 할당 :
		arr = new int[4];

		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;

		// JVM이 기본값으로 초기화 했는지 확인

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * 100;
		}
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);

	}

	public void method2() {
		// 선언과 동시에 초기화
		int[] arr = { 10, 20, 30, 40, 50 };

		for (int i : arr) {
			System.out.println(i);
		}

	}

	/**
	 * 오늘의 점심 메뉴 뽑기
	 */
	public void method3() {

		String[] menus = { "순대국", "닭갈비", "햄버거", "짬뽕", "설렁탕", "김치찌개", "제육덮밥", "샐러드", "추어탕", "김밥" };

		int randomNumber = (int) (Math.random() * menus.length);

		System.out.printf("오늘의 메뉴는 \"%s\" 입니다!!", menus[randomNumber]);
	}

	/**
	 * Java 배열 사용시 주의할
	 */
	public void method4() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Store and output the input integer in each array element");
		long[] arr = new long[3];

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] 값 입력 : ", i);
			arr[i] = sc.nextLong();
		}

		for (long num : arr) {
			System.out.println(num);
		}

		// arr[3]= 5;

	}

	/**
	 * 인원 수를 입력 받아 그 크기를 가지는 정수 배열을 선언, 할당하고
	 * 
	 * 각 배열 요소에 점수를 입력받아 저장.
	 * 
	 * 입력이 완료되면 합계, 평균, 최대값, 최솟값 출력하기
	 */
	public void method5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int size = sc.nextInt();

		int[] scoreArr = new int[size];

		int sum = 0;
		double avg;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < scoreArr.length; i++) {
			System.out.printf("%d번째 인덱스 점수 입력 : ", i);
			scoreArr[i] = sc.nextInt();
			sum += scoreArr[i];
			if(max < scoreArr[i] ) {
				max = scoreArr[i];
			}
			if(min > scoreArr[i]) {
				min = scoreArr[i];
			}
		}

		avg = sum / scoreArr.length;	
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}

}
