package condition.service;

import java.util.Scanner;

/**
 * 기능(예제, 연습문졔) 제공용 클래스
 */
public class ConditionService {

	// 필드(field) == 멤버 변수 == 인스턴스 변수
	// 해당 클래스(객체) 내에서 언제, 어디서든지 사용가능한 변수
	Scanner sc = new Scanner(System.in);

	/**
	 * 1~10 사이 난수(정수)가 짝수인지 홀수인지 검사
	 */
	public void method1() {
		int randomNumber = (int) (Math.random() * 10 + 1);

		System.out.printf("%d 는 %s수 입니다.", randomNumber, randomNumber % 2 == 0 ? "짝" : "홀");
	}

	/**
	 * 나이 입력받아서 어린이 청소년 성인 구분
	 * 
	 * <pre>
	 * 13세 이하 어린이
	 * 13세 초과 19세이하 청소년
	 * 20세 이상 성인
	 * </pre>
	 */
	public void method2() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();

		if (age <= 13) {
			System.out.printf("%d 세는 %s", age, "어린이");
		} else if (age < 20) {
			System.out.printf("%d 세는 %s", age, "청소년");
		} else {
			System.out.printf("%d 세는 %s", age, "성인");
		}
	}

	/**
	 * 나이를 입력받아 구분하기
	 * 
	 * <pre>
	 * 13세 이하 어린이
	 * 13세 초과 19세이하 청소년
	 * - 14~16세 : 청소년(중)
	 * - 17~19세 : 청소년(고)
	 * 20세 이상 성인
	 * 0 미만 100 이상 : 잘못 입력하셨다.
	 * </pre>
	 */
	public void method3() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		String result;

		if (age < 0 || age >= 100) {
			System.out.println("잘못 입력하셨습니다.");
			return; // 메서드(함수)를 종료하고 호출한 곳으로 돌아감
		}

		if (age <= 13) {
			result = "어린이";
		} else if (age >= 20) {
			result = "성인";
		} else {
			result = (age <= 16) ? "청소년(중)" : "청소년(고)";
		}
		System.out.printf("%d세는 %s", age, result);
	}

	// -----------------------------------------------------------------
	/* switch - case - default */

	/**
	 * [성적 판별기]
	 * 
	 * <pre>
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 성적 부여
	 * 
	 * - 중간고사 (40%), 기말고사(50%), 과제(10%)
	 * 
	 * - 입력 시 각각 100점 만점으로 입력 받음
	 * 
	 * - 합산된 점수에 따라 성적 부여
	 * 
	 * 95점 이상 : A+
	 * 90점 이상 : A
	 * 85점 이상 : B+
	 * 80점 이상 : B
	 * 75점 이상 : C+
	 * 70점 이상 : C
	 * 65점 이상 : D+
	 * 60점 이상 : D
	 * 나머지    : F
	 * 
	 * 
	 * [실행 화면]
	 * 이름 : 홍길동
	 * 중간고사 점수(40%) : 100
	 * 기말고사 점수(50%) : 80
	 * 과제 점수(10%) : 50
	 * 
	 * 홍길동의 최종 점수 : 85.0점
	 * 성적 : B+
	 * </pre>
	 */
	public void method4() {
		double score = 0;
		int midScore;
		int finalScore;
		int assignment;
		String grade;
		System.out.print("이름 : ");
		String name = sc.next();

		// 하나만 예외처리 해봄
		while (true) {
			System.out.print("중간고사 점수(40%) : ");
			midScore = sc.nextInt();
			if (midScore <= 100 && midScore >= 1) {
				break;
			}
			System.out.println("잘못된 입력입니다. 다시 입력하세요.");
		}

		System.out.print("기말고사 점수(50%) : ");
		finalScore = sc.nextInt();

		System.out.print("과제 점수(10%) : ");
		assignment = sc.nextInt();

		score = midScore * 0.4 + finalScore * 0.5 + assignment * 0.1;

		switch ((int) (score / 5)) {
		case 20, 19:
			grade = "A+";
			break;
		case 18:
			grade = "A";
			break;
		case 17:
			grade = "B+";
			break;
		case 16:
			grade = "B";
			break;
		case 15:
			grade = "C+";
			break;
		case 14:
			grade = "C";
			break;
		case 13:
			grade = "D+";
			break;
		case 12:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.printf("%s의 최종점수 : %.1f점 \n 학점: %s", name, score, grade);

	}

	/**
	 * ConditionService에 작성된 메서드를 골라서 실행하는 메서드
	 */
	public void displayMenu() {
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.print("메뉴 번호 입력 >> ");
		int input = sc.nextInt();

		// 같은 클래스 내 필드, 메서드는 이름만 부르면 호출 가능!
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
		default:
			System.out.println("없는 메뉴 번호 입니다.");
		}
	}
}
