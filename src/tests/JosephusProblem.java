package tests;

import queues.CircularQueue;

public class JosephusProblem {

	public static <E> E josephuses(CircularQueue<E> a, int k) {
		if(a.isEmpty()) return null;
		while(a.size()!=1) {
			for(int i=0;i<k;i++) 
				a.rotate();
			
			System.out.println("Removed :- "+ a.dequeue());
		}
		return a.first();
	}
	
	public static <E> CircularQueue<E> createQueue(E[] e) {
		CircularQueue<E> ans=new CircularQueue<>();
		for(E tmp : e) {
			ans.enqueue(tmp);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String[] a1={"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
		String[ ] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"}; 
		String[ ] a3 = {"Mike", "Roberto"}; 

		
		System.out.println("The winner :- " + josephuses(createQueue(a1), 3));
		System.out.println("The winner :- " + josephuses(createQueue(a2), 7));
		System.out.println("The winner :- " + josephuses(createQueue(a3), 9));
		
	}

}
