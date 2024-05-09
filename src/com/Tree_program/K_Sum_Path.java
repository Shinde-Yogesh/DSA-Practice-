package com.Tree_program;

import java.util.ArrayList;
import java.util.Scanner;

public class K_Sum_Path {
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

	public int sumK(Node root, int k) {
		ArrayList<Integer> path = new ArrayList<>();
		return countPaths(root, k, path);
	}

	private int countPaths(Node root, int k, ArrayList<Integer> path) {
		if (root == null)
			return 0;

		// Add current node to the path
		path.add(root.data);

		// Count the paths with sum k ending at the current node
		int count = countPathsWithSum(root, k, path);

		// Recur for left and right subtrees
		count += countPaths(root.left, k, path);
		count += countPaths(root.right, k, path);

		// Remove current node from the path
		path.remove(path.size() - 1);

		return count;
	}

	private int countPathsWithSum(Node node, int k, ArrayList<Integer> path) {
		int count = 0;
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			sum += path.get(i);
			if (sum == k) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		K_Sum_Path obj = new K_Sum_Path();
		Node root = obj.buildTree();
		System.out.println(obj.sumK(root, 3));
	}
}
