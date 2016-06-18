package stacks;

import lists.SinglyLinkedList;
import higherlevelabstraction.Stack;

public class LinkedStack<E> implements Stack<E>, Cloneable {
	
	private SinglyLinkedList<E> list=new SinglyLinkedList<>();//empty list Existing class as a hidden field
	
	public LinkedStack() {
		
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public E top() {
		return list.getFirst();
	}
	//Additional method to clone the existing stack
	public LinkedStack<E> clone() throws CloneNotSupportedException {
		LinkedStack<E> newest=(LinkedStack<E>) super.clone();
		if(size()==0) return null;
		newest.list=list.clone();
		return newest;
	}

}
