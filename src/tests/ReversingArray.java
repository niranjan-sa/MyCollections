package tests;

import java.util.Arrays;

import stacks.ArrayStack;
import higherlevelabstraction.Stack;

public class ReversingArray {

	/*Generic method for the stack implementation*/
	public static <E> void reverse(E[] a) {
		Stack<E> buff=new ArrayStack<E>(a.length);
		for(int i=0; i<a.length; i++) 
			buff.push(a[i]);
		for(int i=0; i<a.length; i++) 
			a[i]=buff.pop();
	}
	
	public static void main(String[] args) {
		Integer arr[]={1, 2 , 6};
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}

}
