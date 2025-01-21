package common;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[자기소개 문장 생성 프로그램]");
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		System.out.print("키 입력(cm) : ");
		double height = sc.nextDouble();
		
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		// Scanner 에서 char 자료형을 읽어오는 방법 제공 X
		// -> 문자열을 읽어와 0번째 인덱스 문자 하나만 잘라냄
		
		System.out.println("------------------------------");
		System.out.println("[자기소개 문장]");
		
		System.out.printf("안녕하세요 제 이름은 %s이고, 나이는 %d세, 키는 %.1fcm인 %c성 입니다.", name, age, height, gender);
	}
}
