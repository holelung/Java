package section01;

public class OuterClass1 {
	
	private int num = 10;
	
	private void test() {
		System.out.println("OuterClass1의 test() 메서드 입니다.");
		
		// 멤버 끼리는 서로 호출 가능(접근 제어가관련 x)
		System.out.println("num : " + num);
	}
	
	/* 외부 클래스 메서드를 이용해서 내부 클래스 객체 생성 */
	public void displayMessage() {
		System.out.println("[외부 클래스에서 내부 클래스 객체 생성]");
		
		InstanceInnerClass inner =new InstanceInnerClass();
		inner.display();
	}
	
	
	
	
	
	
	/* 인스턴스 내부 클래스 정의 == OuterClass1의 멤버 */
	class InstanceInnerClass{
		void display() {
			System.out.println("외부 클래스의 num: " + num);
			num = 300; // OuterClass1의 멤버 변수 값 변경
			test();    // OuterClass1의 멤버 메서드 호출
			
			// -> 인스턴스 내부 클래스는 외부 클래스 멤버 접근 가능!
		}
		
	}
}
