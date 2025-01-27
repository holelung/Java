package service;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayService2 {

	/**
	 * 얕은 복사, 깊은 복사
	 */
	public void method1() {
		int[] arr1 = { 10, 20, 30, 40, 50 };

		// arr1에 저장된 주소를 copyArr1에 대입
		int[] copyArr1 = arr1;

		// Arrays 클래스 : 배열 관련 유용한 기능 제공 클래스

		// Arrays.toString(배열명) :
		// 배열에 저장된 모든 값을 하나의 문자열로 반환
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("copyArr1 : " + Arrays.toString(copyArr1));

		copyArr1[0] = 999;

		System.out.println("변경 후");
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("copyArr1 : " + Arrays.toString(copyArr1));

		// hashCode() : 주소를 이용해서 만든 해시함수 결과
		System.out.println(arr1.hashCode());
		System.out.println(copyArr1.hashCode());

		System.out.println("-------------------------------");
		// 깊은 복사

		int[] arr2 = { 5, 6, 7, 8 };

		// 방법1
		int[] copyArr2 = Arrays.copyOf(arr2, arr2.length);

		// 방법2
		int[] copyArr3 = arr2.clone();

		// 방법3
		int[] copyArr4 = new int[arr2.length];
		System.arraycopy(arr2, 0, copyArr4, 0, arr2.length);

		// 방법4
		int[] copyArr5 = new int[arr2.length];
		for (int i = 0; i < arr2.length; i++) {
			copyArr5[i] = arr2[i];
		}

		System.out.println("arr2 : " + Arrays.toString(arr2));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		System.out.println("copyArr3 : " + Arrays.toString(copyArr3));
		System.out.println("copyArr4 : " + Arrays.toString(copyArr4));
		System.out.println("copyArr5 : " + Arrays.toString(copyArr5));

		copyArr2[0] = 33;
		copyArr3[0] = 44;
		copyArr4[0] = 55;
		copyArr5[0] = 66;

		System.out.println("변경 후");
		System.out.println("arr2 : " + Arrays.toString(arr2));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		System.out.println("copyArr3 : " + Arrays.toString(copyArr3));
		System.out.println("copyArr4 : " + Arrays.toString(copyArr4));
		System.out.println("copyArr5 : " + Arrays.toString(copyArr5));

		System.out.println("hashCode 확인");
		System.out.println(arr2.hashCode());
		System.out.println(copyArr2.hashCode());
		System.out.println(copyArr3.hashCode());
		System.out.println(copyArr4.hashCode());
		System.out.println(copyArr5.hashCode());

	}

	/**
	 * 2차원 배열 선언, 할당, 초기화
	 */
	public void method2() {

		int[][] arr = new int[2][3];

		// 2차원 배열 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;

		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;

		// 확인
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));

	}

	/**
	 * 2차원 배열 선언 및 초기
	 */
	public void method3() {

		Scanner sc = new Scanner(System.in);

		// 1
		int[] arr1 = { 30, 40, 50, 60 };
		int[] arr2 = { 15, 25, 35, 45 };

		int[][] arr = { arr1, arr2, { 99, 88, 77, 66 } };

		
		System.out.print("검색할 숫자 입력 : ");
		int input = sc.nextInt();
		
		for(int row =0; row< arr.length; row++) {
			for(int col = 0; col<arr[row].length; col++) {
				if(arr[row][col] == input) {
					System.out.printf("%d행 %d열에 있습니다.", row, col);
					return;
				}
			}
		}
		System.out.println("존재하지 않습니다.");
		sc.close();
		
	}

}
