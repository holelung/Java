package common;

public class PrintEx {
	public static void main(String[] args) {
		/* System.out ==
		 * 
		 * 1) System.out.print(출력 내용):
		 * 
		 * 
		 * 2) System.out.println(출력내용): 
		 */
		
		// print()
		System.out.print("이름 : " ); // 줄바꿈(개행) X
		System.out.print("홍길동");
		System.out.print(", age : 20");
		
		// println()
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println("-------------------------");
		System.out.println("printf() check");
		
		String name = "신짱구"; // 참조형 값 저장 x, 값의 위치(주소) 저장
		
		int age = 5; // integer 4byte
		double height = 105.9; // double  8byte
		char gender = '남'; // char, 2byte
		boolean javaStudy = false; // boolean, 1byte
		
		System.out.println(name+"는 "+ age+"세 " + gender+ "아로 키는 " + height +"cm 이며, 자바 공부 여부:"+javaStudy);
		System.out.printf("%s는 %d세 %c아로 키는 %.1fcm 이며, 자바 공부 여부:%b", name, age, gender, height, javaStudy);
		
		
		// 왼쪽 정렬
		System.out.println();
		System.out.printf("%-6s/%-6d", name, age);
		
		// 오른쪽 정렬
		System.out.println();
		System.out.printf("%6s/%06d", name, age);
		
		
		//-------
		// escape
		
		System.out.println("------------------------------------");
		System.out.println("[escape]");
		
		System.out.print("1\t2\t3\n");
		System.out.print("\"홍길동\"의 자료형은 String\r");
		System.out.print("\\o/\n");
		
		
		
		
		
	}

}
