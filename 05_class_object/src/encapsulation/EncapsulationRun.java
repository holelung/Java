package encapsulation;

public class EncapsulationRun {

	public static void main(String[] args) {

		Person person1 = new Person("홍길동", -189.233);
		Person person2 = new Person();
		
		person2.setPerson("김미영", 200.3);
		
		System.out.println(person1.getPerson());
		System.out.println(person2.getPerson());
	}
}
