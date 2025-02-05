package section02.dto;

// 추상 클래스인 Animal 상속
// -> 부모인 Animal의 필드/메서드(정상/추상)를 물려받음
// -> 상속받은 추상 메서드를 사용하고 싶으면 재정의(오버라이딩) 강제함



public class Cat extends Animal{
	
	// field
	private String fur; // 털
	
	
	public Cat() {
		super("포유류");
	}
	
	public Cat(String fur) {
		super("포유류");
		this.fur = fur;
	}

	@Override
	public String toString() {
		return super.toString() + " / 털 : "+fur;
	}
	
	
	@Override
	public void move() {
		System.out.println("고양이 : 4족 보행, 사뿐 사뿐 움직임");
	}
	
	@Override
	public void eat() {
		System.out.println("고양이 : 깨작 깨작 먹음");
	}
	
	@Override
	public void sleep() {
		System.out.println("고양이 : 엎드려서 잠");
	}
	

	
	public String getFur() {
		return fur;
	}
	
	public void setFur(String fur) {
		this.fur = fur;
	}
}
