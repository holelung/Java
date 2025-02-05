package section02.dto;


/*
 * 추상 클래스
 * 1) 추상 메서드를 포함한 클래스
 * 2) 객체(instance)로 만들 수 없는 클래스
 * 
 * - abstract 예약어 작성
 * 
 * - 추상 클래스는 보통 미완성 부분(추상 메서드)을 가지고 있어 객체생성이 불가!
 * 
 * - 직접 객체 생성은 불가능 하지만 자식클래스에서 상속받아 미완성 부분(추상메서드)을
 *   정의해서 완성시켜주면 자식객체는 생성이 가능하다(오버라이딩 강제화,동적바인딩)
 * 
 * 
 * - 추상 클래스도 생성자는 필수로 존재해야 한다
 *  상속 받은 자식 내부에 부모 부분이 생성되야하기 때문에
 * 
 * -  부모 부분에서 추상메서드는 어떻게 구현되는가
 * -> 오버라이딩된 자식의 메서드로 연결됨
 * 
 * - 추상 클래스 사용이유
 * 
 */
public abstract class Animal {	
	
	private String type; // 종

	// 생성자
	public Animal() {
		super();
	}

	public Animal(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "type : " + type;
	}

	/*
	 * 추상 메서드 - 공통된 기능의 이름을 갖지만 정의를 할 수 없는 메서드
	 * 
	 * - 메서드 정의부분 {} 대신 ; 작성
	 * 
	 * - abstract 예약어 작성
	 */
	public abstract void move();

	public abstract void eat();

	public abstract void sleep();

	// getter/setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
