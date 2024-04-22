package com.Tree_program;

import java.util.Scanner;

import com.Tree_program.Height_Of_Binary_Tree.Node;

public class Diameter_of_Binary_Tree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int height(Node node) {
		// base case
		if (node == null) {
			return 0;
		}

		// the formula for calculate
		// Max(leftNode ,rightNode)+1
		int left = height(node.left);
		int right = height(node.right);

		int ans = Math.max(left, right) + 1;
		return ans;
	}

	int diameter(Node root) {
		// Your code here

		// base case
		if (root == null) {
			return 0;
		}
		int option1 = diameter(root.left);
		int option2 = diameter(root.right);
		int option3 = height(root.left) + height(root.right) + 1;

		int ans = Math.max(option1, Math.max(option2, option3));
		return ans;
	}

	public Node buildTree() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data : ");
		int data = sc.nextInt();

		if (data == -1) {
			return null; // Return null to indicate no node
		}

		Node root = new Node(data); // Create the root node

		// Build left subtree
		System.out.println("Enter the data for inserting in left node " + data);
		root.left = buildTree();

		// Build right subtree
		System.out.println("Enter the data for inserting in right node " + data);
		root.right = buildTree();

		return root; // Return the constructed subtree
	}

	public static void main(String[] args) {
		Diameter_of_Binary_Tree obj = new Diameter_of_Binary_Tree();
		Node root = obj.buildTree();
		System.out.println("The Height of Tree : "+obj.height(root));
		System.out.println("The Diameter of Tree : "+obj.diameter(root));

	}

}
