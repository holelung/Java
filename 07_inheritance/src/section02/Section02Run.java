package section02;

public class Section02Run {
	public static void main(String[] args) {
		
		// 학생 객체 생성1 -> 기본생성자
		Student s1 = new Student();
		
		// 학생 객체 생성2 -> 매개변수가 있는 생성자
		Student s2 = new Student("홍길동", 13, "코딩초등학교");
		
	  System.out.println(s1.toString());
	  System.out.println(s2.toString());
	}
}
