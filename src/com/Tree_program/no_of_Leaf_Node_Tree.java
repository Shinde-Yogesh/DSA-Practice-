package com.Tree_program;

public class no_of_Leaf_Node_Tree {
	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

	public static int inorder(BinaryTreeNode<Integer> root, int count) {
		// Base case: If root is null, return count
		if (root == null) {
			return count;
		}

		// Recursive call to traverse left subtree
		count = inorder(root.left, count);

		// Check if the current node is a leaf node
		if (root.left == null && root.right == null) {
			count++; // Increment count if it's a leaf node
		}

		// Recursive call to traverse right subtree
		count = inorder(root.right, count);

		return count;
	}

	public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
		// Initialize count to 0
		int count = 0;

		// Call inorder traversal function to count leaf nodes
		count = inorder(root, count);

		// Return the count of leaf nodes
		return count;
	}

	public static void main(String[] args) {

	}
}
