package tests;

import lists.SinglyLinkedList;

public class SinglyLLTest {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list=new SinglyLinkedList<Integer>();
		System.out.println(list);
		list.addFirst(45);
		System.out.println(list);
		list.addFirst(67);
		System.out.println(list);
		list.addLast(89);
		System.out.println(list);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getClass());
		System.out.println(list.removeFirst()+"\n"+list);
		SinglyLinkedList<Integer> t=new SinglyLinkedList<Integer>();
		t.addFirst(33);
		t.addFirst(9);
		t.addFirst(22);
		t.addFirst(50);
		System.out.println(t);
		try {
			System.out.println(t.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
