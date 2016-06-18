package stacks;

import java.util.Arrays;

import higherlevelabstraction.Stack;

public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY=1000;
	private int top=-1;
	private E[] data;
	private int size;
	
	
	public ArrayStack() {
		this(CAPACITY); //Calling another constructor using this REMEMBER.
	}
	public ArrayStack(int cap) {
		data=(E[])new Object[cap];//This is very important stuff we cannot create an array of generic 
								  //variables.
	}
	
	public int capacity() {
		return data.length;
	}
	
	@Override
	public int size() {
		return top+1;
	}

	@Override
	public boolean isEmpty() {
		return top==-1;
	}

	@Override
	public void push(E e) {
		if(size==data.length) {//No need of extra variable called capacity
			throw new IllegalStateException("Stack is full!!");
		} 
		data[++top]=e;
	}

	@Override
	public E pop() {	
		if(isEmpty()) return null;
		E ans=data[top];
		data[top]=null;//De referencing for the garbage collection
		top--;
		return ans;
	}

	@Override
	public String toString() {
		return "ArrayStack [top=" + top + ", data=" + Arrays.toString(data)
				+ ", size=" + size + "]";
	}
	@Override
	public E top() { //returns the element on the top
		if(isEmpty()) return null;	
		return data[top];
	}
}
