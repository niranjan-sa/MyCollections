package tests;

public class PrintBSTArray {

	// Just an in order traversal
	static void printSorted(int nos[], int start, int end) {
		if(start > end) 
			return ;
		
		printSorted(nos, 2*start+1, end);
		
		System.out.print(nos[start]+" ");
		
		printSorted(nos, 2*start+2, end);	
	}
	
	public static void main(String[] args) {
		int []nos={4, 2, 5, 1, 3};//This is the array representing the 
					//level order traversal of a BST
		printSorted(nos, 0, nos.length-1);
	}

}
