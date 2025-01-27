package staticmember;

public class Korean {
	
	/* static(정적인, 고정된)
	 * 고정된 영역(static 메모리영역)
	 * 모든 객체가 공유할 멤버(필드/메서드)를 생성해서 공유
	 */
	/* 필드 == 멤버 변수*/
	/*
	 * 클래스 변수
	 * - 클래스명.변수명 으로 접근하기 때문에 클래스 변수라고 함
	 * 
	 * - 생성시기 : 프로그램 실행 시 static 영역에 생성
	 * - 소멸시기 : 프로그램 종료 시
	 */
	
	// 필드가 생성될 때 국가코드 82로 명시적 초기화
	public static int population = 50000000; // 인구
	private static int nationalCode = 82; // 국가코드
	private String name; // 이름
	private String id; // 주민등록번호

	//클래스 초기화 블럭
	static {
		System.out.println("클래스 초기화 블럭! 프로그램 실행시 실행!");
		nationalCode = 99;
		// name = "김길동";
		// 클래스 초기화 블럭에서 인스턴스 변수는 초기화 불가능
	}
	
//인스턴스 초기화 블럭
	{
		System.out.println("객체 생성 마다 수행");
		name = "홍길동";
		id="123124-213423";
		nationalCode = 999;
	}

	
	// basic constructor
	public Korean() {
		Korean.population++;
	}

	// Constructor with parameters
	public Korean(String name, String id) {
		this.name = name;
		this.id = id;
		Korean.population++;
	}

	public String toString() {
		return String.format("이름 : %s / 주민등록번호 : %s / 국가코드 : %d", name, id, nationalCode);
	}

	// 필드 간접 메서드 getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// static 메서드만들어야 nationalCode에 접근가능?
	public static int getNationalCode() {
		return nationalCode;
	}
	public static void setNationalCode(int nationalCode) {
		Korean.nationalCode = nationalCode;
	}

}
