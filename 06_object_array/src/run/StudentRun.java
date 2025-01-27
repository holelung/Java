package run;

import view.StudentView;

/* Run
 * - 자바 프로그램 실행용 클래스
 */

public class StudentRun {
	public static void main(String[] args) {
		
		// 객체를 1회용으로 사용하는 방법
		new StudentView().mainMenu();
		// 새로운 StudentView 객체가 생성되자마자
		// mainMenu() 메서드 호출
		
		// -> mainMenu()가 종료되면
		// (왜? 참조하는 변수가 없어서 GC가 없애버림)
		
	}

}
