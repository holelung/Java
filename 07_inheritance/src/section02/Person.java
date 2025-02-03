package section02;

public class Person {
	private String name;
	private int age;

	public Person() {
		System.out.println("[Person 기본 생성자로 생성됨]");
	}

	// 매개변수 생성
	public Person(String name, int age) {
		System.out.println("[Person 매개변수 있는 생성자로 생성됨]");
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return String.format("name : %s / age : %d\n", name, age);
	}

	// getter/setter area
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
