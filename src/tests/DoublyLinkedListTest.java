package tests;

import lists.DoublyLinkedList;

public class DoublyLinkedListTest {
	public static void main(String[] args) {
		DoublyLinkedList dbl=new DoublyLinkedList();
		System.out.println(dbl);
		dbl.addFirst(45);
		System.out.println(dbl);
		dbl.addFirst(22);
		dbl.addLast(2);
		System.out.println(dbl);
		System.out.println(dbl.size());
		dbl.addLast(44);
		dbl.removeFirst();
		System.out.println(dbl);
		System.out.println(dbl.removeLast());
		
	}
}
