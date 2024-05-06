package com.Tree_program;

import java.util.ArrayList;
import java.util.Scanner;

public class Boundary_Traversal {
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

	public Node buildTree() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data : ");
		int data = sc.nextInt();

		if (data == -1) {
			return null; // Return null to indicate no node
		}

		Node root = new Node(data); // Create the root node

		// Build left subtree
		System.out.println("Enter the data for inserting in left " + data);
		root.left = buildTree();

		// Build right subtree
		System.out.println("Enter the data for inserting in right  " + data);
		root.right = buildTree();

		return root; // Return the constructed subtree
	}

	void traversalLeft(Node root, ArrayList<Integer> ans) {
		// base case
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}
		ans.add(root.data);

		if (root.left != null) {
			traversalLeft(root.left, ans);
		} else {
			traversalLeft(root.right, ans);
		}
	}

	void traversalRight(Node root, ArrayList<Integer> ans) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}

		if (root.right != null) {
			traversalRight(root.right, ans);
		} else {
			traversalRight(root.left, ans);
		}
		ans.add(root.data);
	}

	void traverseLeaf(Node root, ArrayList<Integer> ans) {
		// base case
		if (root == null) {
			return;
		}

		// check for leaf node
		if (root.left == null && root.right == null) {
			ans.add(root.data);
			return;
		}
		traverseLeaf(root.left, ans);
		traverseLeaf(root.right, ans);
	}

	ArrayList<Integer> boundary(Node node) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (node == null) {
			return ans;
		}
		ans.add(node.data);
		// left part print/store
		traversalLeft(node.left, ans);

		// traversal leaf node
		traverseLeaf(node.left, ans);
		traverseLeaf(node.right, ans);

		// traversal right part
		traversalRight(node.right, ans);
		System.out.println(ans);
		return ans;

	}

	public static void main(String[] args) {
		Boundary_Traversal obj = new Boundary_Traversal();
		Node root = obj.buildTree();
		obj.boundary(root);
	}
}
