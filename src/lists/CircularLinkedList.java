package lists;
/*
 * 
 *  size(): Returns the number of elements in the list.
	isEmpty(): Returns true if the list is empty, and false otherwise.
	ﬁrst(): Returns (but does not remove) the ﬁrst element in the list.
	last(): Returns (but does not remove) the last element in the list.
	addFirst(e): Adds a new element to the front of the list.
	removeFirst(): Removes and returns the ﬁrst element of the list.
	rotate();
 * 
 * 
 * */


public class CircularLinkedList<E> {
	//Class representing a node
	public static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element=e;
			next=n;
		}
		
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	//Instance variables
	private Node<E> tail;
	private int size;
	
	//Constructors
	public CircularLinkedList() {}
	
	//Access methods
	public int size() {return size;}
	
	public boolean isEmpty() {return size==0;}
	
	public E getFirst() { // returns but does not remove
		if(isEmpty()) return null;
		else return tail.getNext().getElement();
	}
	
	public E getLast() {	// returns but does not remove
		if(isEmpty()) return null;
		else return tail.getElement();
	}
	
	//Update methods
	
	public void rotate() {	//rotate the first element to the back of the list
		if(tail!=null)
			tail=tail.getNext();
	}
	
	public void addFirst(E data) { //adds the element to the front of the list
		if(size==0) {
			tail=new Node<E>(data, null);
			tail.setNext(tail);//Link itself circularly
		} else {
			Node<E> tmp=new Node<E>(data, tail.getNext());
			tail.setNext(tmp);
		}
		size++;//Don't forget this
	}
	
	public void addLast(E data) {//Just adjust the pointer :)
		addFirst(data);//Cool Trick kakke keep it up :) :) :) :) :) :)
		tail=tail.getNext();
	}
	
	public E removeFirst() {//deletes the first element 
		if(isEmpty()) return null;
		Node<E> head=tail.getNext();
		if(head==tail) {
			tail=null;
		} else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}
	
	//To add the removeLast method.
	
	public String toString() {
		if(isEmpty()) return "List Empty";
		String ans="[ ";
		for(int i=0; i<size; i++) {
			rotate();
			ans+=tail.getElement()+" ";
		}
		return ans+="]";
	}
	
}
