package tests;

import higherlevelabstraction.Stack;
import stacks.LinkedStack;

public class ParenthesisMatching {
	//Optimized logic very nice program
	public static boolean isMatched(String exp) {
		final String open="({[";//create opening parenthesis
		final String close=")}]";//closing parenthesis
		Stack<Character> stk=new LinkedStack<>();
		//parse the string
		for(char c: exp.toCharArray()) {
			if(open.indexOf(c)!=-1) stk.push(c); //left delimiter pushed
			else if(close.indexOf(c)!=-1) {//right delimeter encountered
				if(stk.isEmpty()) return false;//stack empty false
				if(close.indexOf(c)!=open.indexOf(stk.pop())) { //pop if matched
					return false;
				}
			}
		}
		return stk.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isMatched("{{{[[))]]]}"));
		System.out.println(isMatched("({)}"));
		System.out.println(isMatched("{}{}{([])}"));

	}

}
