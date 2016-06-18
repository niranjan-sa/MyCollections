package higherlevelabstraction;

public interface Queue<E> {
	 /*Returns the number of elements in the queue */ 
	 int size();
	 /*Tests whether the queue is empty*/
	 boolean isEmpty();
	 /*Returns, but does not remove, the ﬁrst element of the queue (null if empty).*/
	 E first();
	 /* Inserts an element at the rear of the queue*/
	 void enqueue(E e);
	 /*Removes and returns the ﬁrst element of the queue (null if empty)*/
	 E dequeue();	
}
