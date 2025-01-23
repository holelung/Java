package basic;

/**
 * 현실에서의 객체 : 속성(data), 기능(method)을 가지고 있는
 * 식별 가능한 것
 * 
 * OOP : 객체와 객체가 상호작용을 하면 사건이 발생한다
 * 			 라는 개념을 프로그램 만들 때 적용한 패러다임
 *
 * 클래스 
 * - 객체가 가지고 있는 속성, 기능을 정의한 것
 * - 이를 통해 새로운 자료형을 만들 수 있기 때문에
 * 	 "사용자 정의 자료형"이라고도 한다.
 * 
 * 자바에서 객체
 * - 클래스에 정의된 내용을 토대로
 * 	 new 연산에 의해 JVM Heap 메모리 영역에 생성된 것
 * 
 * 
 */
public class Car {

	// Field == member Variable - 객체의 속성
	String brand;
	String model;
	int year;
	
	// method - 객체의 기능/행동
	// 생성자
	public Car (String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
	};
	
	public void info() {
		System.out.printf("이 차는 %s의 %s이며, %d년식 입니다.\n", this.brand, this.model, this.year);
	}
	
	public void start() {
		System.out.printf("%s의 시동을 켭니다.\n", this.model);
	}
	
	public void stop() {
		System.out.printf("%s의 시동을 끕니다.\n", this.model);
	}
	

}