package stack;

public class Run {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.solution("()()"));
		System.out.println(s.solution("(())()"));
		System.out.println(s.solution(")()("));
		System.out.println(s.solution("(()("));
	}
}
