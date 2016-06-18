package trees;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	
	static class Node {
		int data;
		Node left, right;
		
		public Node(){
			left=right=null;
			//Added now
		}
		
		public Node (int d) {
			data=d;
			left=right=null;
		}
		
		
		
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
		
		
	}
	
	//Declarations
	private Node root;
	private int size;
	private int iSize;
	private Stack<Node> stk;
	private Queue<Node> q;
	
	//
	public int getSize() {
		size(root);
		return size;
	}
	
	
	public BinarySearchTree() {
		root=null;
		iSize=0;//Size maintained implicitly while mutation on tree
	}
	
	//inserts the given node
	public void insert(int data) {
		root=insert(root, data);
		iSize++;
	}
	
	private Node insert(Node root, int data) {
		if(root==null)
			return new Node(data);
		
		if(data < root.data) {
			root.left = insert(root.left, data);
		} else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		return root;
	}
	//
	
	//deletes the given node
	public void delete(int data) {
		root=delete(root, data);
		iSize--;
	}
	
	private Node delete(Node root, int data) throws IllegalArgumentException{
		if (root == null) {
			throw new IllegalArgumentException("Element not found");
		}
		
		else if (data < root.data) {
			root.left = delete(root.left, data);
		} 
		 
		else if (data > root.data) {
			root.right = delete(root.right, data);
		}
		
		else {
			Node temp;
			if(root.left != null && root.right !=null) {
				temp = getMax(root.left);
				root.data = temp.data;
				root.left = delete(root.left, root.data);
			} 
			else if(root.left==null) {
				temp = root;
				root = root.right;
				temp.left = temp.right =null;
				temp = null;
			}
			else {
				temp = root;
				root = root.left;
				temp.left = temp.right = null;
				temp = null;
			}	
		}
		return root;
	}
	//
	
	//Performs in order traversal
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(""+root.data+" ");
			inorder(root.right);
		}
	}
	//
	
	//returns maximum element
	public int getMax(){
		return getData(getMax(root));
	}
	
	//
	private Node getMax(Node root) {
		Node walk=root;
		while(walk.right!=null) {
			walk=walk.right;
		}
		return walk;
	}
	//
	
	//set the height of the tree
	public int height() {
		return height(root);
	}
	
	private int height(Node root) {
		if(root==null) 
			return 0;//Zero based height
		return 1+Integer.max(height(root.left), height(root.right));
	}
	//
	
	//Returns the minimum element
	public int getMin(){
		return getData(getMax(root));
	}
	
	private Node getMin(Node root) {
		Node walk=root;
		while(walk.left!=null) {
			walk=walk.left;
		}
		return walk;
	}
	//
	
	public int getData(Node node) {
		return node!=null?node.data:Integer.MAX_VALUE;
	}
	//Equivalent to find method
	
	//
	public boolean contains(int data) {
		return contains(root, data)!=null;
	}
	
	private Node contains(Node root, int data) {
		//Technique inorder traversal
		if(root == null)
			return null;
		
		Node tmp1;
		tmp1=contains(root.left, data) ; //Recursive call for left subtree
		if(root.data == data) 
			return root;	//Processing of the root
		if(tmp1!=null)
			return tmp1;
		
		return contains(root.right, data); //Recursive call for left subtree
	}
	//
	
	//
	public int kthSmallestNo(int k) {
		ind=0;
		
		if(k<1) 
			throw new InvalidParameterException("Please give correct index");
		
		return getData(kthSmallestNo(root, k));
	}
	static int ind=0;
	//The use of the static variable is important
	//Because the value of the mutated variable persists in the 
	//forward calls in java as normal variables are pass by value
	//we need a persistent counter between fwd and rev calls 
	//only a static variable is capable of doing this in java
	private Node kthSmallestNo(Node root, int k) {
		if(root==null) {
			return null;
		}
		Node temp=kthSmallestNo(root.left, k);
		if(temp!=null)
			return temp;
		if(++ind==k)
			return root;
		return kthSmallestNo(root.right, k);
	}
	//
	
	//sets the size of the tree
	private void size(Node root) {
		if(root!=null) {
			size(root.left);
			size++;
			size(root.right);
		}
	}

	//TODO function must return NULL when a, b not present in the tree
	public int findLCA(int a, int b) {
		return getData(findLCA(root, a, b));
	}
	
	//Assumption a > b
	//Shadowing of the variable this root in the argument is not 
	//the same as the instance variable
	//Complexity O(h) Space complexity O(1)
	private Node findLCA(Node root, int a, int b) {
		
		while(root!=null) {
			
			if(root.data >= a && root.data <= b)
				return root;
			
			// If both n1 and n2 are smaller than root, then LCA lies in left
			if(a < root.data  && b < root.data )
				root = root.left;
			
			// If both a and b are greater than root, then LCA lies in right
			else if(a > root.data && b > root.data)
				root = root.right;
		}
		return root;
	}
	
	//Recursive version of above function
	private Node findLCAR(Node root, int a, int b) {
		if(root == null)
			return null;
	
		if(root.data > a && root.data > b)
			return findLCAR(root.left, a, b);
		
		else if(root.data < a && root.data < b)
			return findLCAR(root.right, a, b);

		return root;
	}
	
	
	//returns the in order successor of the given node
	public int inorderSuccessor(int k) {
		Node node=contains(root, k);
		if(node == null) throw new IllegalArgumentException("Node not found");
		return getData(inorderSuccessor(root, node));
	}
	
	//TODO Testing has to be done
	private Node inorderSuccessor(Node root, Node node) {
		if(node.right != null)
			return getMin(node.right);
		
		Node succ=null;
		while(root!=null) {
			
			if (node.data < root.data) {
				succ = root;
				root = root.left;
			} 
			else if(node.data > root.data) {
				root = root.right;
			}
			else
				break;
		}
		return succ;
	}
	
	//print all the nodes in the given range n1 n2 inclusive
	public void printRange(int n1, int n2) {
		printRange(root, n1, n2); 
	}
	
	private void printRange(Node root, int n1, int n2) {
		if(root==null)
			return;
		
		printRange(root.left, n1, n2);
		
		if(root.data >= n1 && root.data <= n2) 
			System.out.print(root.data+" ");
		
		printRange(root.right, n1, n2);
	}
	
	//Function to construct a BST from given sorted array
	public static BinarySearchTree buildBst(int []nos) {
		BinarySearchTree tree=new BinarySearchTree();
		tree.root = buildBst(nos, 0, nos.length-1);
		return tree;
	}
	
	private static Node buildBst(int []nos, int start, int end) {
		
		if(start > end)
			return null;
		
		int mid = (start+end)/2;
		Node node=new Node(nos[mid]);
		
		node.left = buildBst(nos, start, mid-1);
		node.right = buildBst(nos, mid+1, end);
		
		return node;
	}

	//To each node in the BST add the values of all other nodes 
	//having values greater than current node
	//Trick perform reverse in order traversal and add the sum to 
	//each node
	//reverse in order traversal right - root - left :)
	static int sum;
	public void addGreaterValues() {
		sum=0;
		addGreaterValues(root);
		//here we cannot take sum as second parameter
		//it simply does'nt work
		//addGreaterValues(root, sum);does not work as shadowing takes place
	}
	//static variable sum is used here
	//TODO eliminate use of static variable
	//Problem solved using static variable
	//In java the if the value of variable sum if passed as parameter
	//does not work properly as when the value is updated in forward call
	//the change does not reflect in earlier call
	//O(n)
	private void addGreaterValues(Node root) {
		
		if(root == null) return;
		
		addGreaterValues(root.right);
		sum+=root.data;
		root.data = sum;
		addGreaterValues(root.left);
	}

	public boolean equals(Object o) {
		boolean res=true;
		
		if(!(o instanceof BinarySearchTree))
			res=false;
		else
			return compare(root, ((BinarySearchTree)o).root);
		return res;
	}
	//compares two binary search trees
	private boolean compare(Node rt1, Node rt2) {
		
		if(rt1==null && rt2==null)
			return true;
		else if(rt1==null || rt2==null)
			return false;
		else {
			if(rt1.data != rt2.data)
				return false;
			else 
				return (compare(rt1.left, rt2.left) && compare(rt1.right, rt2.right));
		}
	}
	
	//returns the ceil value for a given key in the binary search tree
	public int ceilValue(int d){
		return ceilValue(root, d);
	}
	
	private int ceilValue(Node root, int key) {	
		if(root == null) 
			return -1;
		
		if(root.data == key)
			return key;
		
		if(root.data < key)
			 return ceilValue(root.right, key);
	
		int lp = ceilValue(root.left, key);	
		return (lp >= key)?lp:root.data;
	}

	//Deletes the binary search tree completely
	public void clear() {
		root=clear(root);
	}
	
	private Node clear(Node root) {
		if(root == null)
			return null;
		
		root.left=clear(root.left);
		root.right=clear(root.right);
		root.left = root.right = null;
		return null;
	}

}
