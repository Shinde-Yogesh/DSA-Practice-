package com.Tree_program;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Binary_Tree_Creation {
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

	static void levelOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("Tree is Empty");
			return; // If the tree is empty
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private static Node takeInput() {
		Scanner sc = new Scanner(System.in);
		Node root = null;

		System.out.println("Enter the data to create BST (-1 to end): ");
		while (true) {
			int data = sc.nextInt();
			if (data == -1) {
				break;
			}
			root = insertIntoBST(root, data);
		}
		sc.close();
		return root;
	}

	private static Node insertIntoBST(Node root, int data) {
		// Base case
		if (root == null) {
			root = new Node(data);
			System.out.println("Inserted " + data);
			return root;
		}

		if (data > root.data) {
			// Right part to work
			System.out.println("Insert " + data + " to right of " + root.data);
			root.right = insertIntoBST(root.right, data);
		} else {
			// Left side
			System.out.println("Insert " + data + " to left of " + root.data);
			root.left = insertIntoBST(root.left, data);
		}
		return root;
	}

	// for the Binary search code
	public static boolean searchInBST(Node root, int x) {
		if (root == null) {
			return false;
		}

		if (root.data == x) {
			return true;
		}

		if (root.data > x) {
			// left part
			return searchInBST(root.left, x);
		} else {
			return searchInBST(root.right, x);
		}

	}

	public static void main(String[] args) {
		System.out.println("Enter the data to create BST:");
		Node root = takeInput();

		System.out.println("Printing the BST:");
		levelOrderTraversal(root);
	}
}
