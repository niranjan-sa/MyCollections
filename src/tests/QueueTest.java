package tests;

import queues.ArrayQueue;

public class QueueTest {
	public static void main(String[] args) {
		ArrayQueue<Integer> arq=new ArrayQueue<>(3);
		arq.enqueue(1);
		arq.enqueue(2);
		arq.enqueue(3);
		System.out.println(arq);
		arq.dequeue();
		System.out.println(arq);
	}
}
