package generics;

public class TestCal {
	public static void main(String[] args) {
		Calculator<Integer> calc = (x,y) -> x + y;
		int result = calc.add(20, 30);
		System.out.println(result);
		
		// Calculator<String> calcStr = (x, y) -> x+y;
		
	}
}
