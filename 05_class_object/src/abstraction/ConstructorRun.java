package abstraction;

public class ConstructorRun {

	public static void main(String[] args) {
		Student std1 = new Student();
		
		System.out.println(std1.toString());
		
		System.out.println("-----------------------------");
		
		Student std2 = new Student("20250001", "고길동");
		System.out.println(std2.toString());
		
		System.out.println("-----------------------------");
		Student std3 = new Student("20250002", "강수호", 45, 55, 35, 30);
		System.out.println(std3.toString());
		
		System.out.println("-----------------------------");
		Student std4 = new Student("2025003", "똑똑핑", 100, 100, 100, 98);
		System.out.println(std4.toString());
	}
}
