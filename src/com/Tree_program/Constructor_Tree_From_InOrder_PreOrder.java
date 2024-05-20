package com.Tree_program;

import java.util.Scanner;

public class Constructor_Tree_From_InOrder_PreOrder {
	static class Node {
		int data;
		Node left;
		Node right;

		// Constructor
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static int preOrderIndex = 0;

	public static Node buildTree(int inorder[], int preorder[], int n) {
		preOrderIndex = 0;
		return solve(inorder, preorder, 0, n - 1, n);
	}

	private static Node solve(int[] inorder, int[] preorder, int inOrderStart, int inOrderEnd, int n) {
		// Base case
		if (preOrderIndex >= n || inOrderStart > inOrderEnd) {
			return null;
		}

		int element = preorder[preOrderIndex++];
		Node root = new Node(element);
		int position = findPosition(inorder, inOrderStart, inOrderEnd, element);

		// Recursively build left and right subtrees
		root.left = solve(inorder, preorder, inOrderStart, position - 1, n);
		root.right = solve(inorder, preorder, position + 1, inOrderEnd, n);
		return root;
	}

	private static int findPosition(int[] inorder, int inOrderStart, int inOrderEnd, int element) {
		for (int i = inOrderStart; i <= inOrderEnd; i++) {
			if (inorder[i] == element) {
				return i;
			}
		}
		return -1;
	}

	private static void printPostorder(Node root) {
		if (root == null) {
			return;
		}
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");
	}
	 public static void main(String[] args) {
	     
		 // Example 1
	        int N1 = 4;
	        int inorder1[] = {1, 6, 8, 7};
	        int preorder1[] = {1, 6, 7, 8};
	        Node root1 = buildTree(inorder1, preorder1, N1);
	        printPostorder(root1);
	        System.out.println();
	 }
}
