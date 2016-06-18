package queues;

import lists.CircularLinkedList;

public class CircularQueue<E> implements higherlevelabstraction.CircularQueue<E> {

	private CircularLinkedList<E> list=new CircularLinkedList<>();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E first() {
		return list.getFirst();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E dequeue() {
		return list.removeFirst();
	}

	@Override
	public void rotate() {
		list.rotate();
	}

	@Override
	public String toString() {
		return "CircularQueue [list=" + list + "]";
	}
	
	
}
