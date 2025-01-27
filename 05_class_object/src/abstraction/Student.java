package abstraction;

// class : Document that define "Field" and "Method" for creating Objects
public class Student {

	// Abstraction
	// 객체의 공통점을 추출하고, 불필요한 부분을 제거하여
	// 유연성을 확보하는 것

	/*
	 * Field!
	 */
	private String studentNumber; // 학번
	private String name; // 이름
	// 과목점수
	private int html;
	private int css;
	private int js;
	private int java;

	/* Method */

	// Constructor
	public Student() {
		System.out.println("Student 객체가 기본 생성자로 생성되었습니다.");
		// 객체가 Heap 영역에 생성될
		// 필드 값이 모두 JVM 초기값으로 세팅
		// (heap 영역은 비어있는 상태로 존재 불가)
		studentNumber = "2025xxxx";
		name = "미입력";
		html = 100;
		css = 100;
		js = 100;
		java = 100;

	}

	/* 매개 변수가 있는 생성자 */
	// 학번, 이름만
	public Student(String studentNumber, String name) {
		this.studentNumber = studentNumber;
		this.name = name;
	}

	// 전부 다
	public Student(String studentNumber, String name, int html, int css, int js, int java) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.html = html;
		this.css = css;
		this.js = js;
		this.java = java;
	}
	// OverLoading (과적)
	// 하나의 클래스 내에 같은 이름의 메서드를 여러개 작성하는 기술
	// 메서드의 이름은 중복이 불가능 하지만
	// 매개변수(순서, 타입, 개수)를 다르게 하여
	// 같은 이름의 메서드라도 구분할 수 있게 된다.
	
	
	// 성적 합계 계산
	public int getSum() {
		return html + css + js + java;
	}

	// 성적 평균 계산
	public double getAverage() {
		return getSum() / 4.0;
	}

	// 학생 성적 정보를 문자열로 반환
	public String toString() {

		/*
		 * [반환형] String String.format("템플릿(패턴)", 패턴에 대입될 값); - 지정된 형식의 문자열을 만드는 메서드
		 * 
		 * - System.out.printf() 처럼 작성하지만 출력되지 않고 String 으로 반환
		 */

		String str = String.format("[%s] %s\n" + "HTML : %d / CSS : %d / JS : %d / Java : %d\n" + "합계 : %d\n" + "평균 : %.2f",
				studentNumber, name, html, css, js, java, getSum(), getAverage());

		return str;
	}

	/* Getter/Setter Area */
	// Getter: 객체의 필드 값을 반환
	// Setter: 객체의 필드 값을 새로 대입함
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getCss() {
		return css;
	}

	public void setCss(int css) {
		this.css = css;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

}
