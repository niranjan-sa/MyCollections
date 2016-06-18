package tests;

import heaps.MaxHeap;

public class HeapTest {

	public static void main(String[] args) {
		MaxHeap<Integer> hp=new MaxHeap<>(10);
		
		hp.insert(2);
		hp.insert(6);
		hp.insert(9);
		hp.insert(10);
		hp.insert(1);
		hp.insert(-3);
		hp.insert(90);
		hp.insert(0);
		hp.insert(1020);
		hp.insert(100);
		
		hp.insert(2000);
		
		
		System.out.println(hp.getMax());
		System.out.println(hp.extractMax());
		hp.decreaseKey(0, 60);
		System.out.println(hp);
		
		MaxHeap<String> frnd= new MaxHeap<>(10);
		
		frnd.insert("Niranjan");
		frnd.insert("Prasad");
		frnd.insert("Juman");
		frnd.insert("Bingo");
		frnd.insert("Shantyee");
		frnd.insert("Rushikesh");
		frnd.insert("Harry");
		frnd.insert("poo");
		
		System.out.println(frnd);
		
		System.out.println(frnd.getMax());
	}

}
