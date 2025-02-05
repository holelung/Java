package section01.run;

import section01.dto.Child;
import section01.dto.Parent;

public class TestRun {
	public static void main(String[] args) {
		
		// 부모 참조 변수 = 부모 객체
		Parent p1 = new Parent();
		
		/* p1이 호출 가능한 메서드
		 * - Parent`s method + Inherit from Object method
		 */
		System.out.println("p1.getLastName() : "+ p1.getLastName());
		System.out.println("p1.hashCode() : "+ p1.hashCode());

		System.out.println("---------------------------------");
		
		// 자식 참조 변수 = 자식 객체
		Child c1 = new Child("신",500,"993Torbo S");
		
		// c1 이 호출 가능한 메서드
		// - Child + Object, Parent method
		System.out.println("c1.getCar() : "+ c1.getCar());
		System.out.println("c1.getLastName() : "+ c1.getLastName());
		System.out.println("c1.hashCode() : "+ c1.hashCode());
		
		
		/* 다형성 (Polymorphism)
		 * - 하나의 객체가 다양한 객체 형태로 변하는 성질
		 * 
		 * 다형성 - 업캐스팅(Up Casting)
		 * - 자식 객체의 형태를 부모 객체 형태로 변환
		 * 
		 * - '부모' 참조 변수 = new '자식' 객체
		 * => 자식 객체가 부모 객체 형태로 변한 것 처럼 보임
		 */
		
		
		// 업 캐스팅 확인
		// 부모 참조 변수 = 자식 객체 (오류 발생 x)
		//  -> 값처리 원칙 무시한거 아닌가? 아니다
		// -> 자식 객체 내 부모 객채 부문 참조하기 때문에
		Parent p2 = new Child("김", 9999, "아반떼");
		
		// p2가 참조 가능한 메서드
		// Only call  Parent, Object method
		// - Child 객체 이지만 Parent로 변경되어 Child 메서드 인식 불가
		System.out.println("p2.getLastName = "+p2.getLastName());
		System.out.println("p2.hashCode = "+p2.hashCode());
		// System.out.println(p2.getCar()); 이거 오류
		
		System.out.println("----------------------------------");
		
		// 다운 캐스팅 확인
		// -> 참조 변수를 자식 자료형으로 강제 형변환
		System.out.println(((Child)p2).getCar());
		
		// 얕은 복사(주소만 복사)
		Child c2 = (Child)p2;
		
		
		
	}
}
