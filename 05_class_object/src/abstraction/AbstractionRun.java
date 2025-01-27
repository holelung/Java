package abstraction;

public class AbstractionRun {
	public static void main(String[] args) {
		Student std1 = new Student();
		
		std1.setStudentNumber("2025001");
		std1.setName("홍길동");
		std1.setHtml(100);
		std1.setCss(88);
		std1.setJs(77);
		std1.setJava(96);
		System.out.println(std1.toString());
		
		System.out.println("-----------------------------");
		
		Student std2 = new Student("2025002","김철수",100,98,95,95);
		
		System.out.println(std2.toString());
	}
	

	
}
