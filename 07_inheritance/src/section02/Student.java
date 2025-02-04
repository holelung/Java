package section02;

/**
 * Person 클래스를 상속 받은 Student 클래스
 */
public class Student extends Person {

	private String schoolName; // 학교명

	public Student() {
		super();
		System.out.println("[Student 기본 생성자로 생성됨]");
	}

	// 매개변수가 있는 생성자
	// -> student 가 가지고 있는 모든 필드(학교명,이름,나이) 초기화
	public Student(String name, int age, String schoolName) {
		// super() 는 무조건 첫줄!!
		super(name, age);
		this.schoolName = schoolName;
		System.out.println("[Student 매개 변수가 있는 생성자로 생성됨]");
	}

	// 연속으로 재정의
	// Object.toString() -> Person.toString() -> Student.toString()
	@Override
	public String toString() {
		return super.toString() + "/ 학교명 : "+ schoolName;
	}

	// introduce Overriding
	// 오버라이딩 성립조건
	// [변경 불가]
	// -반환명
	// 메서드명
	// 매개변수(개수, 순서,타입)
	
	// [변경 가능]
	// - 접근 제어자( 기존 -> 넓은범위)
	// - 예외 처리 (기존->넓은 범위)
	
	@Override// 오버라이딩 명시 + 성립조건 맞는지 검사 지시
	public String introduce(String nickName) {
		return String.format("[Student가 재정의] 내 이름은 %s, %s 이죠!", super.getName(),nickName);
	}
	
	
	// getter/setter
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
