package tests;

import higherlevelabstraction.Stack;
import stacks.LinkedStack;

public class HtmlTagMatching {
	//Function to checked the balanced tags in html
	public static boolean isHTMLTagMatched(String html) {
		Stack<String> stk=new LinkedStack<>();
		int j=html.indexOf('<');
		while(j!=-1) {
			int k=html.indexOf('>',j+1);
			//important condition
			if(k==-1)
				return false;
			//stripping away <>
			String tag=html.substring(j+1, k);
			
			if(!tag.startsWith("/"))
				stk.push(tag);
			else{
				if(stk.isEmpty())
					return false;
				if(!tag.substring(1).equals(stk.pop()))
					return false;	
			}
			j=html.indexOf('<', k+1);
		}
		return stk.isEmpty();
	}
	
	public static void main(String[] args) {
		String html="<html>This is us </html>";
		System.out.println(isHTMLTagMatched(html));
	}

}
