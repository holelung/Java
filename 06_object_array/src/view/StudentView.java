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
			System.out.println("8. 학생 제거(인덱스)");
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
			case 5: upadateByIndex(); break;
			case 6: selectScore(); break;
			case 7: selectMinMax(); break;
			case 8:	deleteStudent(); break;
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
	 * - 인덱스 번호 입력 받아 해당 인덱스에 해당 학생이 있는지 확인
	 * 1) index 범위 초과 : "인덱스 범위가 올바르지 않습니다"
	 * 2) 참조하는 학생이 없을 경우 :
	 * 	"해당 인덱스에 학생이 존재하지 않습니다."
	 * 
	 * - 인덱스에 학생이 있을 경우
	 *  HTML, CSS, JS, Java 점수를 순서대로 입력받은 후
	 *  void StudentService.updateScore 호출
	 */
	private void upadateByIndex() {
		System.out.println("\n----- 학생 정보 수정 -----\n");
		System.out.print("수정할 학생 번호 입력(idx) : ");
		int idx = sc.nextInt();
		
		int check = service.findIndex(idx);
		if(check==1) {
			System.out.println("인덱스 범위가 올바르지 않습니다.");
			return;
		}else if(check ==2) {
			System.out.println("해당인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		System.out.println("1. 정보 수정");
		System.out.println("2. 점수 수정");
		System.out.println("수정할 영역을 선택하세요. >> ");
		int input = sc.nextInt();	
		if(input == 1) {
			modifyInfo(idx);
		}else if(input ==2 ) {
			modifyScore(idx);
		}else {
			System.out.println("잘못된 번호를 입력하셨습니다.");
			return;
		}
		
	}
	
	private void modifyInfo(int idx) {
		System.out.println("\n----- 학적 정보 수정 -----\n");
		System.out.print("학번 : ");
		String studentNumber = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		service.modifyInfo(idx, studentNumber, name, gender);
		
	}

	private void modifyScore(int idx) {
		// sc.next() / sc.next000()
		// - 띄어쓰기 / 엔터 입력 전 까지만 인식
		
		System.out.println("\n----- 학생 점수 수정 -----\n");
		System.out.print("점수입력 순서대로 : \n");
		int html = sc.nextInt();
		int css = sc.nextInt();
		int js = sc.nextInt();
		int java = sc.nextInt();
		
		service.updateScore(idx, html, css, js, java);
	}
	
	
	/**
	 * 6. 학생 점수조회(점수, 합계, 평균)
	 * <pre>
	 * 	- 인덱스 번호를 입력 받아 해당 인덱스에 학생이 있는지 확인
	 * 1) 인덱스 범위 초과 : "잘못된 인덱스 범위"
	 * 2) 참조하는 학생이 없을 경우 : "해당인덱스에 학생이 존재하지 않습니다."
	 * 
	 * - 인덱스 정상 입력
	 * 해당 인덱스번째 학생 (StudentDTO)을 반환
	 * 
	 * - 합계와 평균 구하기
	 * - 아래와 같은 형식으로 출력하기
	 * 
	 * ------------------------------------
	 * [20250001]짱구(남)
	 * HTML : 10 / CSS : 20 / JS :30 / Java : 40
	 * 합계 : 100
	 * 평균 : 25.0
	 * -------------------------------------
	 * </pre>
	 * 
	 */
	private void selectScore() {
		System.out.println("\n----- 학생 점수 조회(인덱스/ 점수 합계) -----\n");
		System.out.print("학생 인덱스 입력 : ");
		int idx = sc.nextInt();
		int check = service.findIndex(idx);
		
		// 학생조회 예외체크
		if(check==1) {
			System.out.println("인덱스 범위가 올바르지 않습니다.");
			return;
		}else if(check ==2) {
			System.out.println("해당인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		StudentDTO student = service.oneStudent(idx);
		System.out.println("---------------------------------------");
		System.out.println(student.toString());
		System.out.printf("합계 : %d\n", student.sumScore());
		System.out.printf("평균 : %.1f\n", student.avgScore());
		System.out.println("---------------------------------------");
	}
	
	/** 7. 평균 최고점, 최저점 학생조회
	 * <pre>
	 *  String StudentService.selectMaxMin() 메서드를 호출하여
	 *  아래와 같은 문자열을 반환받아 출력하기
	 *  
	 *  --------------------
	 *  최고점 : 유리(85.4)
	 *  최저점 : 짱구(32.6)
	 *  --------------------
	 *  
	 * </pre>
	 * 
	 */
	private void selectMinMax() {
		System.out.println("\n----- 평균 꼴지, 1등 조회 -----\n");
		
		service.selectMaxMin();
		
		String result = service.selectMaxMin();
		System.out.println("--------------------");
		System.out.println(result);
		System.out.println("--------------------");
		
	}
	
	/** 8. 학생 삭제(index)
	 * - index 입력받아서 검사
	 *	(범위초과, null 검사)
	 *
	 * - 정말 삭제할지 확인
	 * -> "정말로 삭제 하시겠습니까?(Y/N) : Y"
	 * 
	 * - N 입력시 : "취소 되었습니다" 출력후 return;
	 * 
	 * - Y 입력시 : 
	 *  1) students 배열에서 입력 받은 index 번째 요소를 null 로 변환
	 *  
	 *  2) 삭제된 index 뒤에 요소를 하나씩 당겨오기
	 *  
	 *  3) "삭제 되었습니다" 출력 후 return;
	 *  
	 */
	private void deleteStudent() {
		System.out.println("\n---------학생 삭제(index)--------\n");
		System.out.print("학생 인덱스 입력 : ");
		int idx = sc.nextInt();
		int check = service.findIndex(idx);
		
		// 학생조회 예외체크
		if(check==1) {
			System.out.println("인덱스 범위가 올바르지 않습니다.");
			return;
		}else if(check ==2) {
			System.out.println("해당인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		// 삭제 체크 및 삭제 실행
		System.out.print("정말로 삭제 하시겠습니까?(Y/N) : ");
		char remind = sc.next().charAt(0);
		// string 으로 비교한다면
		// String remind = sc.next();
		// if(remind.equals("Y"))
		// 문자열은 equals 사용한다.
		
		
		switch(remind){
		case 'Y': case 'y':
			service.deleteStudent(idx);
			return;
		case 'N': case'n':
			System.out.println("취소 되었습니다.");
			return;
		default:
			System.out.println("Y/y, N/n만 입력해주세요.");
			return;
		}
	}
}



