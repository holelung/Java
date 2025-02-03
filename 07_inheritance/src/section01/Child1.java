package section01;


/* 상속 : 
 * 부모의 코드(필드, 메서드)를 물려받
 * 자식이 자신의 것 처럼 사용
 * 
 * 상속 키워드 : extends(확장하다)
 * -> 부모의 코드를 물려받아 자식의 크기가 커지기 때문에
 * 
 * **주의사항**
 * 1) 부모의 코드중 생성자는 상속 불가
 * 
 * 2) 부모의 private필드/메서드도 상속은 되지만
 * 자식이 직접 접근할 순 없다.
 * (간접 접근 필요)
 * 상속 관계여도 다른 객체로 인식되기 때문
 */
public class Child1 extends Parent{
	
//	private String lastName = "김"; // 성
//	private String firstName = "산"; // 이름
//	private String address = "서울시 강남구"; // 집주
//	private int money = 5000;
	
	// Child1만의 field
	private String laptop;
	
	public Child1() {
		System.out.println("**Child1 객체 생성됨!@**");
		// 자식 객체 생성시 부모객체도 생성됨~(부모 먼저)
		
		setFirstName("산");
		setAddress("서울시 강남구");
		setMoney(5000);
		laptop = "macbook pro m4";
	}

	public String getLaptop() {
		return laptop;
	}
	public void setLaptop(String laptop) {
		this.laptop =laptop;
	}
}
