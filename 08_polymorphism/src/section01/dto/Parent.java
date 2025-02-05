package section01.dto;


/**
 * 부모 역할 클래스
 * (Object 상속)
 */
public class Parent {
	
	// 필드 == 멤버 변수
	private String lastName = "제갈";
	private int money = 10000;
	
	
	// 기본 생성자
	public Parent() {
		super(); // 부모 생성자 호출(미작성시 컴파일러가 추가)
		// -> Object() 기본 생성
	}

	// 매개변수가 있는 생성자
	public Parent(String lastName, int money) {
		super();
		this.lastName = lastName;
		this.money = money;
	}

	
	/* Object.toString 오버라이딩 */
	// [자동 완성 방법 1]
	// opt + cmd + s 에서 Override/implement Methods.. 
	
	// [자동 완성 방법 2]
	//  오버라이딩 하려는 메서드 이름 작성 후 ctrl + space 자동완성
	
	// [자동 완성 방법 3]
	// alt + shift + s -> s-> enter?
	
	@Override
	public String toString() {
		
		return "Parent [lastName="+lastName+", money="+money+"]";
	}
	

	
	
	

	
	// getter/setter
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
}
