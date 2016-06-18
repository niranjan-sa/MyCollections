package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

import higherlevelabstraction.Position;
import higherlevelabstraction.PositionalList;

public class LinkedPositionalList<E> implements PositionalList<E> {

	private static class Node<E> implements Position<E> {
		
		private E element;
		private Node<E> next;
		private Node<E> prev;
			
		public Node(E element, Node<E> next, Node<E> prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
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

		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public E getElement() throws IllegalStateException {
			if(next==null)
				throw new IllegalStateException();
			return element;
		}
	}//--------end of nested node class-------------
	
	
	//Instance variable of LinkedPositionalList
	private Node<E> head;		//head sentinel
	private Node<E> tail;		//tail sentinel
	private int size=0;			//size
	
	
	public LinkedPositionalList() {
		head=new Node<>(null, null, null);
		tail=new Node<>(null, head, null);
		size=0;
		head.setNext(tail);
	}
	
	//Private utilities
	/*Validates the position and returns it as a node.*/
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
		Node<E> node=(Node<E>)p;	//safe cast
		if(node.getNext()==null)	// convention for defunct node
			throw new IllegalArgumentException("p is no longer valid in the list");
		return node;
	}
	
	/*Returns the given node as a Position (or null, if it is a sentinel).*/
	private Position<E> position(Node<E> node) {
		if(node==head || node==tail)
			return null;			//do not expose user to the sentinels
		return node;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Position<E> first() {
		return position(head.getNext());
	}

	@Override
	public Position<E> last() {
		return position(tail.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node=validate(p);
		return position(node.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node=validate(p);
		return position(node.getNext());
	}

	
	//Private utilities
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest=new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}
	
	//public update methods
	@Override
	public Position<E> addFirst(E e) {		
		return addBetween(e, head, head.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, tail.getPrev(), tail);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node=validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node=validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node=validate(p);
		E answer=node.getElement();
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node=validate(p);
		Node<E> prev=node.getPrev();
		Node<E> next=node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		E ans=node.getElement();
		node.setNext(null);
		node.setPrev(null);
		node.setElement(null);
		return ans;
	}
	
	private class PositionIterator<E> implements Iterator<Position<E>>{

		private Position<E> cursor=(Position<E>) first();//position of first element to report
		private Position<E> recent;						 //position of last reported element
			
		@Override
		public boolean hasNext() throws NoSuchElementException{
			return (cursor!=null);
		}

		@Override
		public Position<E> next() {
			if(cursor==null) throw new NoSuchElementException("nothing left");
			recent=cursor;
			//cursor=after((Position<E>) cursor);
			return recent;
		}
		
	}
}
