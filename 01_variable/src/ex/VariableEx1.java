package ex;

// Java 는 소문자, Camel Case 사용
// 단, 클래스명은 대문자로 시

public class VariableEx1 {
	/** [main method]
	 *	자바 프로그램을 실행 시키기 위한 구문
	 *	  
	 */
	
	public static void main(String[] args) {
		System.out.println("[Java 변수와 자료형]");
		
		/* 변수 : 메모리에 값을 저장하는 공간 
		 * 	+ 해당 공간에 저장할 수 잇는 값을 바꿀 수 있음
		 * 
		 *  * Java 는 JS와 다르게 
		 * 	처음부터 변수의 자료형을 지정해야된다.
		 * 
		 * 1byte ==  8bit
		 * -> 컴퓨터가 데이터 처리(연산)을 위한 최소 단위
		 * 
		 * [Java 기본 자료형 8가지]
		 * - 논리형 
		 * boolean (1byte) - true/false
		 * 
		 * - 정수형 : 양/음 의 정수, 0
		 * byte  (1byte) 
		 * short (2byte)
		 * int   (4byte, 기본)
		 * long  (8byte)
		 * 
		 * - 실수형
		 * float(4byte)
		 * Double(8byte, 기본)
		 * 
		 * - 문자형
		 * char(2byte)
		 */	
		// 변수 선언
		int num1; 
		// 메모리에 int형 정수를 저장할 공간 4byte를 할당하고
		// 해당 공간(변수)의 이름을 num1 이라고 지정
		// * int형 정수 :  -21.47억 ~ +21.47
		
		/* Java 지역 변수는 초기화를 하지 않은 경우
		 * 출력, 연산을 할 수 없다.
		 * (단, 대입연산은 제외)
		 */
		// System.out.println(num1);
		
		/* 변수 초기화(처음 값 대입) */
		num1= 200;
		System.out.println("num1 : " + num1);
		
		// sysout -> ctrl + space -> enter
		System.out.println("---------");
		
		// 논리형 (boolean, 1byte)
		
		boolean bool1 = true;
		boolean bool2 = false;
		
		System.out.println("---논리형---");
		System.out.println("bool1 : "+ bool1);
		System.out.println("bool2 : "+ bool2);
		
		if(bool1 && !bool2) {
			System.out.println("이거 출력 될까?");
		}
		
		/// 정수형 : byte, short, int, long
		System.out.println("---정수형---");
		int intNum1 = 2147483647; // int 최대값
		
		// The literal 2147483648 of type int is out of range 
		// int 범위 초과한 값은 대입불가
		// --> 정수형 중에서 범위가 더 큰 long 사용
		// int intNum2 = 2147483648;
		
//		212322353 <- 일반 정수 표기법 == int로 인식된다.
		/// 2147483648l또는 2147483648L 표기 == long으로 인식
		long longNum1 = 2147483648L;
		/// 자릿수 구분을 위해 _ 사용가능 -> 연산 시 인식 X
		long longNum2 = 30_000_000_000L; // 300
		
		
		System.out.println("intNum1 : " + intNum1);
		System.out.println("longNum1 : " + longNum1);
		System.out.println("longNum2 : " + longNum2);
		
		// byte, short : 다른 언어(C언어)와 호환위해 남겨진 자료형 
		// -> 별도의 literal 표기법 X
		// -> 초기화 시 int 타입 표기법 사용
		byte byteNum = 100;
		short shortNum = 20000;
		
		System.out.println("----------------");
		System.out.println("---실수형----");
		
		float floatNum= 1.23456789f;
		double doubleNum = 1.23456789;
		
		System.out.println("floutNum : " + floatNum);
		System.out.println("doubleNum : " + doubleNum);
		
		System.out.println("-----문자형-----");
		/*	문자형(char, 2byte)
		 * 
		 * 
		 */
		char ch1 = 'A';
		char ch2 = '가';
		char ch3 = '長';
		char ch4 = '★';
		
		System.out.println("ch1 : "+ ch1);
		System.out.printf("%c, %d, %x \n",ch1, (int)ch1, (int)ch1);
		System.out.println("ch2 : "+ ch2);
		System.out.println("ch3 : "+ ch3);
		System.out.println("ch4 : "+ ch4);
	
		/*	String (문자열, 4byte or 8byte)
		 * */
		String str1 = "A";
		String str2 = "AB";
		String str3 = "ABC";
		String str4 = "ABCD";
		System.out.println("str1 : " + str1);
		System.out.println(System.identityHashCode(str1));
		System.out.println("str2 : " + str2);
		System.out.println(System.identityHashCode(str2));
		System.out.println("str3 : " + str3);
		System.out.println("str4 : " + str4);
	}

}
