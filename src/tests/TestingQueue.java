package tests;
import java.util.*;
public class TestingQueue {
	
	static class PQSort implements Comparator<Integer> {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg0-arg1;
		}
		
	}
	
	public static void main(String[] args) {
		Queue<Integer> que=new LinkedList<>();
		que.add(2);
		Queue<Integer> queue=new PriorityQueue<>();
		int arr[]={1,2,3,4,5,6,7,0};
		
		for(Integer q : arr) {
			queue.offer(q);
		}
		System.out.println(queue);//sorting 
		Integer k;
		while(queue.size()!=0) {
			System.out.println(queue.poll());
		}
		
		PQSort pqs=new PQSort();
		
		queue=new PriorityQueue<>(pqs);
		for(Integer q : arr) {
			queue.offer(q);
		}
		System.out.println(queue);//sorting 
		
		while(queue.size()!=0) {
			System.out.println(queue.poll());
		}
	}
}
