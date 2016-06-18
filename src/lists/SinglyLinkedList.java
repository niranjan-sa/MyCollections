package lists;
/*
 * ADT (interface operations)
 * 
 * size(): Returns the number of elements in the list.
 * isEmpty(): Returns true if the list is empty, and false otherwise.
 * ﬁrst(): Returns (but does not remove) the ﬁrst element in the list.
 * last(): Returns (but does not remove) the last element in the list.
 * addFirst(e): Adds a new element to the front of the list.
 * addLast(e): Adds a new element to the end of the list.
 * removeFirst(): Removes and returns the ﬁrst element of the list. 
 * 
 * */
public class SinglyLinkedList<E> implements Cloneable{
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
	
	
	private Node<E> head=null;
	private Node<E> tail=null;
	private int size=0;
	
	//Display methods 
	public boolean isEmpty() {return size==0;}
	
	public int size() {return size;}
	
	public E getFirst() {
		if(!isEmpty()) {
			return head.getElement();
		} 
		return null;
	}
	
	public E getLast() {
		if(!isEmpty()) {
			return tail.getElement();
		} 
		return null;
	}
	
	//To get the i'th element
	public E get(int i) {
			if(i>size||i<0) 
				return null;
			Node<E> tmp=head;
			for(int j=1; j<i; j++)
				tmp=tmp.getNext();
			return tmp.getElement();
		}
	
	//Mutator methods
	public void addFirst(E e) {
		head=new Node<E>(e, head);
		if(size==0) {
			tail=head;
		}
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest=new Node<E>(e, null);
		if(isEmpty()) {
			head=tail=newest;
		} else {
			tail.setNext(newest);
			tail=newest;
		}
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		E answer=head.getElement();
		head=head.getNext();
		size--;
		if(size==0) {
			tail=null;
		}
		return answer;
	}
	
	//Overridden methods
	
	public boolean equals(Object o) {
		if(o==null) return false;//checking for empty ref
		if(getClass()!=o.getClass()) return false;//check if both objects are of SinglyLinkedList
		SinglyLinkedList slist=(SinglyLinkedList)o;//type casting
		if(size!=slist.size) return false;// check for same sizes
		Node walkA=head;
		Node walkB=slist.head;
		while(walkA!=null) {
			if(walkA.getElement()!=(walkB.getElement())) return false;
			walkA=walkA.getNext();
			walkB=walkB.getNext();
		}
		return true;
		
	}
	
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		// always use inherited Object.clone() to create the initial copy 
		SinglyLinkedList<E> other=(SinglyLinkedList<E>)super.clone();
		if(size>0) {
			//we are doing a deep copy here and we do not want the same references to be just copied so we are trying
			//to actually construct a new singly linked list
			other.head=new Node<>(head.getElement(),null);//head node created it's reference is stored into the tail node
			Node<E> walk=head.getNext();
			Node<E> otherTail=other.head;
			while(walk!=null) {
				Node<E> newest=new Node<E>(walk.getElement(), null);
				otherTail.setNext(newest);
				otherTail=newest;
				walk=walk.getNext();
			}
			other.tail=otherTail;
			other.size=size;
		}
		return other;
	}
	
	public String toString() {
		String ans="";
		if(size==0) 
			ans="List is empty";
		else {
			ans="[ ";
			for(int i=1; i<=size; i++)
				ans+=get(i)+", ";
			ans+=" ]";
		}
		return ans;
	}
}
