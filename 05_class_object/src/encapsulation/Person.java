package encapsulation;

public class Person {
	private String personName; // name -> personName 변경
	private double height;
	
	public Person() {}
	
	public Person(String personName, double height) {
		this.personName = personName;
		this.height = Math.abs(height);
	}
	
	public Person(String personName) {
		this.personName = personName;
	}
	
	public void setPerson(String personName, double height) {
		this.personName = personName;
		this.height = Math.abs(height);
	}
	
	public String getPerson() {
		return "이름 : "+personName+"\n 키 : "+height+"\n";
	}
}
