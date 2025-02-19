package generics;

public class UtilRun {
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
    String[] strArray = {"Hello", "World"};
    
    UtilTest.<Integer>printArray(intArray);  // 출력: 1 2 3 4 5
    UtilTest.printArray(strArray);  // 출력: Hello World
	}
}
