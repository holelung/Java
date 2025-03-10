package section02;

public class Section02Run {
	public static void main(String[] args) {
		
		// 학생 객체 생성1 -> 기본생성자
		Student s1 = new Student();
		
		// 학생 객체 생성2 -> 매개변수가 있는 생성자
		Student s2 = new Student("홍길동", 13, "코딩초등학교");
		
	  System.out.println(s1.toString());
	  System.out.println(s2.toString());
	  
	  
	  /* 오버라이딩 테스트 */
	  Person p3 = new Person("짱구", 5);
	  System.out.println(p3 /* .toString() */);
	  System.out.println(p3.introduce("데빌구"));
	  
	  /* [참고]
	   * print 관련 메서드 또는 문자열 + 연결 시
	   * 참조 변수명만 작성하면 자동으로 toString() 호출된다!
	   * (컴파일러가 자동으로 .toString() 추가)
	   */
	  
	  Student s3 = new Student("코난", 8, "사건초등학교");
	  System.out.println(s3);
	  System.out.println(s3.introduce("탐정"));
	}
}
