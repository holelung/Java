package section01.dto;


/**
 * Child 클래
 * (Parent 상속)
 */
public class Child extends Parent{
	
	private String car;
	
	public Child() {
		super();
	}
	
	// 매개변수 있는 생성자
	public Child(String lastName, int money, String car) {
		super(lastName, money);
		this.car = car;
	}
	
	@Override
	public String toString() {
		return super.toString()+"/ Child [car="+car+"]";
	}
	

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	
	
	
}
