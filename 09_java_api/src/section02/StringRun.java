package section02;

public class StringRun {
	public static void main(String[] args) {
		StringService s1 = new StringService();
		
		// s1.test3();
		
		String cc ="";
		int dd = 50;
		switch(dd) {
		case 50 : cc += 'x';
		case 30 : cc += 'y'; break;
		default : cc += 'z';
		}
		
		System.out.println(cc);
		
		
	}
}
