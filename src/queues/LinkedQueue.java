package queues;

import higherlevelabstraction.Queue;
import lists.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

	SinglyLinkedList<E> data=new SinglyLinkedList<>();
	
	public LinkedQueue() {}
	
	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public E first() {
		return data.getFirst();
	}

	@Override
	public void enqueue(E e) {
		data.addLast(e);
	}

	@Override
	public E dequeue() {
		return data.removeFirst();
	}
}
