package tests;

import lists.CircularLinkedList;

public class CircularLinkedListTest {
	public static void main(String[] args) {
		CircularLinkedList<Integer> list1=new CircularLinkedList<Integer>();
		System.out.println(list1);
		System.out.println(list1.size());
		list1.addFirst(2);
		System.out.println(list1);
		list1.addFirst(4);
		System.out.println(list1);
		list1.addFirst(9);
		System.out.println(list1);
		list1.rotate();
		System.out.println(list1);
		list1.addLast(22);
		System.out.println(list1);
		list1.removeFirst();
		System.out.println(list1);
	}
}
