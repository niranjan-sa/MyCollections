package lists;

/*
 * 
 * 	size(): Returns the number of elements in the list.
	isEmpty(): Returns true if the list is empty, and false otherwise.
	ﬁrst(): Returns (but does not remove) the ﬁrst element in the list.
	last(): Returns (but does not remove) the last element in the list.
	addFirst(e): Adds a new element to the front of the list.
	addLast(e): Adds a new element to the end of the list.
	removeFirst(): Removes and returns the ﬁrst element of the list.
	removeLast(): Removes and returns the last element of the list.
 * 
 * 
 * 
 * 
 * 
 * */


public class DoublyLinkedList<E> {
	//---------Nested Node class-----------
	private static class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E data, Node<E> prev, Node<E> next) {
			this.setElement(data);
			this.setNext(next);
			this.setPrev(prev);
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

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
	}
	
	//-----------Class delclaration ends here --------------------
	
	//instance var of doubly linked list
	private Node<E> header;
	private Node<E> trailer;
	private int size=0;
	
	/*Constructs a new empty linked list*/
	public DoublyLinkedList() {
		header=new Node<>(null,null,null);
		trailer=new Node<>(null,null,null);
		header.setNext(trailer);
	}
	
	// Returns the number of elements in the linked list 
	public int size( ) { return size; }
	// tests if empty
	public boolean isEmpty() {return size==0;}
	// return but retain the first element
	public E first() {
		if(isEmpty()) return null;
		else return header.getNext().getElement();
	}
	// return but retain the last element
	public E last() {
		if(isEmpty()) return null;
		else return trailer.getPrev().getElement();
	}
	
	//Public update methods
	//Add new node at the first
	public void addFirst(E e) {
		addBetween(e,header ,header.getNext());
	}
	//Add new node at last
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	public E removeFirst() {
		if(isEmpty()) return null;
		return remove(header.getNext());
	}
	
	public E removeLast() {
		if(isEmpty()) return null;
		return remove(trailer.getPrev());
	}
	
	//Private update methods
	/*Adds an element between two nodes*/
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest=new Node<E>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	private E remove(Node<E> node) {
		Node<E> predecessor=node.getPrev();
		Node<E> successor=node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}

	public String toString() {
		String ans="";
		if(isEmpty()) return ans="Empty List";
		Node<E> node=header.getNext();
		while(node!=trailer) {
			ans=ans+" "+node.getElement();
			node=node.getNext();
		}
		return ans;
	}
}/*End of the doubly linked list class*/