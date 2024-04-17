package com.Tree_program;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int data;
	Node left;
	Node right;

	// constructor
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Binary_Tree {

	public Node buildTree(Node root) {
		System.out.println("Enter the data : ");
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		root = new Node(data);

		if (data == -1) {
			return null;
		}

		System.out.println("Enter the data for inserting in left node " + data);
		root.left = buildTree(root.left);
		System.out.println("Enter the data for inserting in Right node" + data);
		root.right = buildTree(root.right);

		return root;

	}

	public static void levelOrderTraversal(Node root) {
		if (root == null) {
			return; // If the tree is empty
		}

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.print(temp.data + " ");

			// Check and add left child if not null
			if (temp.left != null) {
				queue.add(temp.left);
			}

			// Check and add right child if not null
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		// Create a sample binary tree
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(5);
		root.left.left = new Node(7);
		root.left.right = new Node(11);
		root.right.left = new Node(17);
		

		// Perform level order traversal
		System.out.println("Level Order Traversal:");
		levelOrderTraversal(root);
	}
}
