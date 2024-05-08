package com.Tree_program;

import java.util.Scanner;

/*
public class Sum_of_nodes_Longest_Path {
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

	int maxSum = 0;
	int maxLength = 0;

	public int sumOfLongRootToLeafPath(Node root) {
		findMaxSum(root, 0, 0);
		return maxSum;
	}

	private void findMaxSum(Node root, int sum, int len) {
		if (root == null) {
			return;
		}

		sum += root.data;
		len++;

		if (root.left == null && root.right == null) {
			if (len > maxLength || (len == maxLength && sum > maxSum)) {
				maxLength = len;
				maxSum = sum;
			}
			return;
		}

		findMaxSum(root.left, sum, len);
		findMaxSum(root.right, sum, len);
	}

	public static void main(String[] args) {
		Sum_of_nodes_Longest_Path obj = new Sum_of_nodes_Longest_Path();
		Node root = obj.buildTree();
		System.out.println(obj.sumOfLongRootToLeafPath(root));
	}
}
*/
public class Sum_of_nodes_Longest_Path {
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	/*
	 * public int sumOfLongRootToLeafPath(Node root) { int[] result = new int[2]; //
	 * Array to hold maxSum and maxLength findMaxSum(root, 0, 0, result); return
	 * result[0]; }
	 * 
	 * private void findMaxSum(Node root, int sum, int len, int[] result) { if (root
	 * == null) { return; }
	 * 
	 * sum += root.data; len++;
	 * 
	 * if (root.left == null && root.right == null) { if (len > result[1] || (len ==
	 * result[1] && sum > result[0])) { result[0] = sum; result[1] = len; } return;
	 * }
	 * 
	 * findMaxSum(root.left, sum, len, result); findMaxSum(root.right, sum, len,
	 * result); }
	 * 
	 */
	static int maxs;
    static int maxl;
	public int sumOfLongRootToLeafPath(Node root) {
		int sum = 0;
		int level = 0;
		find(root, level, sum);
		int smax = 0;
		smax = maxs;
		maxl = 0;
		return maxs;
	}

	public static int find(Node root, int sum, int level) {
		if (root == null)
			return 0;
		sum += root.data;
		level = level + 1;
		find(root.left, sum, level);
		find(root.right, sum, level);
		if (level > maxl) {
			maxs = sum;
			maxl = level;
		} else if (level == maxl) {
			maxs = Math.max(sum, maxs);
		}
		return 0;
	}

	public static void main(String args[]) {
		Sum_of_nodes_Longest_Path tree = new Sum_of_nodes_Longest_Path();

		// Example 1
		Node root1 = new Node(4);
		root1.left = new Node(2);
		root1.right = new Node(5);
		root1.left.left = new Node(7);
		root1.left.right = new Node(1);
		root1.right.left = new Node(2);
		root1.right.right = new Node(3);
		root1.left.right.left = new Node(6);

		System.out.println("Example 1: " + tree.sumOfLongRootToLeafPath(root1)); // Output: 13

		// Example 2
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		root2.right.left = new Node(6);
		root2.right.right = new Node(7);

		System.out.println("Example 2: " + tree.sumOfLongRootToLeafPath(root2)); // Output: 11
	}
}