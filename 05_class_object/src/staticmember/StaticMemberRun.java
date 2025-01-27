package staticmember;

public class StaticMemberRun {
	public static void main(String[] args) {
		// 아래 코드가 수행되기 전
		// 이미 static 이 붙은 멤버가 static 영역에 할당되어있음
		
		// className.FieldName
		// nationalCode가 private 로 선언되어서 안됨
//		System.out.println(Korean.nationalCode);
		
		// static 메서드 : 클래스명.스태틱메서드명 으로 호출가능
		System.out.println(Korean.getNationalCode());
		
		Korean kor1 = new Korean("김철수","051212-3333744");
		Korean kor2 = new Korean("황정민","730412-1348327");
		
		System.out.println(kor1.toString());
		System.out.println(kor2.toString());
		System.out.println("인구수 : "+ Korean.population);
		
		// 만약 이미 생성된 모든 Korean 객체의 
		// nationalCode를 수정해야 하는 경우
		Korean.setNationalCode(1);
		
		System.out.println("=====국가코드 변경=====");
		System.out.println(kor1.toString());
		System.out.println(kor2.toString());
		System.out.println("인구수 : "+ Korean.population);
		
		System.out.println("--------------------------------");
		System.out.println("초기화 블럭 확인");
		
		Korean k3 = new Korean();
		Korean k4 = new Korean();
		
		System.out.println(k3.toString());
		System.out.println(k4.toString());
	}
}
