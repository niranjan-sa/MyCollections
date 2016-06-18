package trees;

//Implementation of AVL tree

public class BalancedBinaryTree {

	
	class Node {
		int data;
		Node left, right;
		int height;
		
		public int getData() {
			return data;
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
	
	Node root;
	
	public BalancedBinaryTree() {
		root = null;
	}
	
	
	private int height(Node node) {
		if(node==null)
			return 0;
		return node.height;
	}
	
	
	private Node singleRotateLeft(Node root) {
		
		Node lefty = root.left;
		lefty.right = root;
		root.left = lefty.right;
		
		root.height = Integer.max(height(root.left), height(root.right))+1;
		lefty.height = Integer.max(height(lefty.left), height(lefty.right))+1;
		
		return lefty;
	}
	
	
}
