package view;

import java.util.Scanner;

import dto.StudentDTO;
import service.StudentService;

/* View
 * - 보여지는 용도의 기능(입력/출력)을 담당하는 클래스
 */

public class StudentView {
	// 특별한 경우아니면 캡슐화
	// 입력용 객체
	private Scanner sc = new Scanner(System.in);

	// 기능 제공용 객체
	private StudentService service = new StudentService();
	
	/**
	 * 학생 관리 프로그램의 메인 메뉴 출력용 메서드
	 */
	public void mainMenu() {
		
		int input = 0; // Variable for menu index
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt(); 
			sc.nextLine();// 입력 버퍼에 남은 내용 모두 제거
			
			System.out.println();// 줄바꿈
			
			switch(input) {
			case 1: addStudent(); break; // clear
			case 2: allStudent(); break; // clear
			case 3: oneStudent(); break; // clear
			case 4: findByName(); break; // clear
			case 5: modifyStudent(); break;
			case 6: checkScore(); break;
			case 7: minMaxStudent(); break;
			case 0: System.out.println("*** 프로그램 종료 ***"); break;
			default : System.out.println("*** 잘못된 메뉴 번호 입력 ***");
			}
			
		}while(input != 0);
		
		sc.close();
	}
	
	
	// private 메서드 : 객체 내부에서만 사용되는 기능
	
	/**
	 * 학생 전체 조회
	 */
	private void allStudent() {
		System.out.println("\n----- 학생 전체 조회 -----\n");
		
		// StudentService 객체에서 모든 학생을 저장한 
		// 객체 배열을 얻어와 화면에 출력
		
		StudentDTO[] students = service.getStudents();
		
		
		// 향상된 for 문
		for(StudentDTO std : students) {
			
			// null.toString() -> 오류가 발생하기 때문에
			// 오류 구문 수행전 검증
			if(std == null) {
				continue;
			}
			
			/* 참조 변수를 
			 * 문자열 만들 때
			 * 또는 print() 관련 메서드에 사용될 때
			 * 
			 * 참조 변수에 저장된 주소가 출력되면 이상하니까
			 * 컴파일러가 자동으로 참조변수.toString()을 호출하도록 변경
			 */
			System.out.println(std);
		}
	}


	/**
	 * 학생 추가
	 */
	private void addStudent() {
		System.out.println("\n----- 학생 추가 -----\n");
		
		System.out.print("학생 번호 : ");
		String studentNumber = sc.next();
		
		System.out.print("학생 이름 : ");
		String name = sc.next();
		
		System.out.print("학생 성별 : ");
		char gender = sc.next().charAt(0);
		sc.nextLine();
		
		boolean complatedAdd = service.addStudent(studentNumber, name, gender);
		
		if(complatedAdd) {
			System.out.println("학생 추가 완료!");
			return;
		}
		System.out.println("정원이 꽉 찼습니다.");
	}
	
	/**
	 * 학생 한명 조회
	 */
	private void oneStudent() {
		System.out.println("\n----- 학생 정보 조회 -----\n");
		System.out.print("인덱스 번호 입력 >> ");
		int idx = sc.nextInt();
		sc.nextLine();
		
		StudentDTO student = service.oneStudent(idx);
		System.out.println(student);
		
		
	}
	
	/**
	 * 이름으로 조회 (동명이인X)
	 */
	private void findByName() {
		System.out.println("\n----- 학생 정보 조회 -----\n");
		System.out.print("학생 이름 입력 >> ");
		String name = sc.next();
		
		StudentDTO student = service.findByName(name);
		if(student == null) {
			System.out.println("해당 학생이 없습니다.");
		}
		System.out.println(student);
	}
	
	/**
	 * 학생 정보 수정
	 */
	private void modifyStudent() {
		
	}
	
	/**
	 * 학생 점수조회(점수, 합계, 평균)
	 */
	private void checkScore() {
		
	}
	
	/**
	 * 평균 최고점, 최저점 학생조회
	 */
	private void minMaxStudent() {
		
	}
}



