package tests;

import queues.CircularQueue;

public class CircularQueueTest {

	public static void main(String[] args) {
		CircularQueue<Integer> cq=new CircularQueue<>();
		cq.enqueue(10);
		cq.enqueue(11);
		cq.enqueue(12);
		cq.enqueue(13);
		System.out.println(cq);
		cq.rotate();
		System.out.println(cq);
	}

}
