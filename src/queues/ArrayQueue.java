package queues;

import java.util.Arrays;

import higherlevelabstraction.Queue;

public class ArrayQueue<E> implements Queue<E> {

	private static final int CAPACITY=1000;
	
	private E[] data;
	private int front=0;
	private int sz=0;
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	public ArrayQueue(int cap) {
		data=(E[]) new Object[cap];//This one's a cool piece of code.
	}
	
	@Override
	public int size() {
		return sz;
	}

	@Override
	public boolean isEmpty() {
		return sz==0;
	}

	@Override
	public E first() {
		return data[front];
	}

	@Override
	public void enqueue(E e) {
		if(sz==data.length) throw new IllegalStateException("Queue is full");
		int pos=(front+sz)%data.length;//This one is really important
		data[pos]=e;
		sz++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()) return null;
		E ans=data[front];
		data[front]=null	;
		front=(front+1)%data.length;//And this one too prevents from going out of the range
		sz--;
		return ans;
	}

	@Override
	public String toString() {
		return "ArrayDequeue [data=" + Arrays.toString(data) + "]";
	}
}
