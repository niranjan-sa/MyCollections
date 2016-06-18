package tests;

import trees.BinarySearchTree;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(2);
		bst.insert(1);
		bst.insert(3);
		bst.insert(-9);
		bst.insert(20);
		bst.insert(7);
		bst.insert(0);
		bst.insert(24);
		bst.insert(22);
		bst.inorder();
		
		//bst.delete(20);
		//bst.delete(-9)
		//System.out.println(bst.height());
		//bst.inorder();
		
		/*System.out.println(bst.contains(-9));
		System.out.println(bst.contains(2));
		System.out.println(bst.contains(20));
		System.out.println(bst.contains(100));
		System.out.println(bst.contains(-190));
		System.out.println(bst.contains(7));
		System.out.println(bst.contains(22));
		
		/*System.out.println(bst.kthSmallestNo(4));
		System.out.println(bst.getSize());*/
		
		//System.out.println(bst.findLCA(0, 7));//
		//bst.inorder();
		
		//bst.printRange(1, 20);
		System.out.println();
		BinarySearchTree builtATree = BinarySearchTree.buildBst(new int[] {1, 3, 4 ,5 ,10, 18});
		builtATree.inorder();
		System.out.println();
		System.out.println(bst.inorderSuccessor(7));
		
		/*
		 * 
		 * 
		 * 
		 * 		   50
           		/      \
         	  30        70
        	/   \      /  \
      	   20    40    60   80 

			The above tree should be modified to following 

              260
           /      \
         330        150
        /   \       /  \
      350   300    210   80
		 * 
		 * */
		
		BinarySearchTree bst1 = new BinarySearchTree();
		bst1.insert(50);
		bst1.insert(30);
		bst1.insert(20);
		bst1.insert(40);
		bst1.insert(70);
		bst1.insert(60);
		bst1.insert(80);
		
		System.out.println();
		bst1.inorder();
		bst1.addGreaterValues();//Bst1 is no more a binary search tree now
		System.out.println();
		bst1.inorder();
		bst1.clear();//deleted the bst
		System.out.println("krem");
		bst1.inorder();
		System.out.println("opq");
		BinarySearchTree b1=new BinarySearchTree();
		BinarySearchTree b2=new BinarySearchTree();
		
		b1.insert(3);
		b1.insert(2);
		b1.insert(1);
		
		b2.insert(3);
		b2.insert(2);
		b2.insert(1);
		b2.insert(10);
		
		System.out.println(b1.equals(b2));
		System.out.println(b2.contains(4));
		
		System.out.println(bst1.ceilValue(220));
	}

}
