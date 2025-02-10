package pccp;


public class Run {
	public static void main(String[] args) {
		String[] arr1 = {"next", "prev"};
		String[] arr2 = {"prev", "next", "next"};
		String[] arr3 = {"next"};
		VideoPlayer vp = new VideoPlayer();
		System.out.println(vp.solution("34:33",	"13:00",	"00:55",	"02:55", arr1));
		System.out.println(vp.solution("10:55",	"00:05",	"00:15",	"06:55", arr2));
		System.out.println(vp.solution("07:22",	"04:05",	"00:15",	"04:07", arr3));
	}
}
