package section01;

public class Main {
	public static void main(String[] args) {
		// 외부 클래스 인스턴스 생성
		OuterClass1 outer = new OuterClass1();
				
		// 외부 클래스내에 존재하는 내부 클래스 인스턴스 생성
		OuterClass1.InstanceInnerClass inner = outer.new InstanceInnerClass();
		
	
		inner.display();
		
		System.out.println("------------------------------------");
		
		outer.displayMessage();
	}
}
