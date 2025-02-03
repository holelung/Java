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

	public String toString() {
		return String.format("name : %s / age : %d / schoolName : %s\n", getName(), getAge(), schoolName);
	}

	// getter/setter
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
