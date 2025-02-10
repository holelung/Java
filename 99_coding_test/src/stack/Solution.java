package stack;

import java.util.Stack;

public class Solution {

	boolean solution(String s) {
		Stack<Character> bracket = new Stack<>();

		bracket.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == ')' && bracket.peek() == '(') {
				bracket.pop();
				continue;
			}
			
			bracket.push(s.charAt(i));
		}


		return bracket.isEmpty() ? true : false;
	}
}
