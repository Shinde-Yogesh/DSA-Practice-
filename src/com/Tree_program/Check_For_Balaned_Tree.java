package com.Tree_program;

import java.util.Scanner;
/*
 * 			Code run but the GFG doesn't support the datatype
public class Check_For_Balaned_Tree {
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

	// Function to check whether a binary tree is balanced or not.
	boolean isBalanced(Node root) {
		// base case
		if (root == null) {
			return true;
		}

		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);

		int leftcall = height(root.left);
		int rightcall = height(root.right);
		boolean diff = false;
		if (leftcall - rightcall <= 1) {
			return !diff;
		}

		if (left && right && diff) {
			return true;
		} else {
			return false;
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
		System.out.println("Enter the data for inserting in left node " + data);
		root.left = buildTree();

		// Build right subtree
		System.out.println("Enter the data for inserting in right node " + data);
		root.right = buildTree();

		return root; // Return the constructed subtree
	}

	public static void main(String[] args) {
		Check_For_Balaned_Tree obj = new Check_For_Balaned_Tree();
		Node root = obj.buildTree();
		System.out.println(obj.height(root));

		// 1 === true
		// 0 === false;

		if (obj.isBalanced(root)) {
			System.out.println("Tree is balanced 1 ");
		} else {
			System.out.println("Tree is not balanaced.. 0");
		}

	}
}*/

/*
public class Check_For_Balaned_Tree {
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

// Helper function to calculate height and check balance
	private static class HeightBalanceResult {
		int height;
		boolean isBalanced;

		public HeightBalanceResult(int height, boolean isBalanced) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

// Function to calculate height and balance condition of a subtree
	private static HeightBalanceResult checkHeightBalance(Node root) {
		// Base case: If node is null, it's balanced with height 0
		if (root == null) {
			return new HeightBalanceResult(0, true);
		}

		// Recursively calculate heights and balance for left and right subtrees
		HeightBalanceResult leftResult = checkHeightBalance(root.left);
		HeightBalanceResult rightResult = checkHeightBalance(root.right);

		// Calculate the height of current node
		int currentHeight = Math.max(leftResult.height, rightResult.height) + 1;

		// Check if the current subtree rooted at 'root' is balanced
		boolean isCurrentBalanced = Math.abs(leftResult.height - rightResult.height) <= 1 && leftResult.isBalanced
				&& rightResult.isBalanced;

		return new HeightBalanceResult(currentHeight, isCurrentBalanced);
	}

// Function to check whether a binary tree is balanced or not
	public static boolean isBalanced(Node root) {
		// Get the result from the helper function
		HeightBalanceResult result = checkHeightBalance(root);

		// Return the balance status of the entire tree
		return result.isBalanced;
	}

// Example of building a tree (input for testing)
	public static Node buildTree() {
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
		Check_For_Balaned_Tree obj = new Check_For_Balaned_Tree();
		Node root = obj.buildTree();
		System.out.println(isBalanced(root));

	}
}*/

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

public class Check_For_Balaned_Tree {
// Function to calculate height of a subtree
	int height(Node node) {
		// Base case: If node is null, height is 0
		if (node == null) {
			return 0;
		}

		// Recursively calculate height of left and right subtrees
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);

		// Height of current node is maximum height of left or right subtree + 1
		return Math.max(leftHeight, rightHeight) + 1;
	}

// Function to check whether a binary tree is balanced or not
	boolean isBalanced(Node root) {
		// Base case: If tree is empty, it's balanced
		if (root == null) {
			return true;
		}

		// Recursively check balance and calculate heights of left and right subtrees
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		// Check if current subtree is balanced
		boolean currentIsBalanced = Math.abs(leftHeight - rightHeight) <= 1;

		// Recursively check balance of left and right subtrees
		boolean leftIsBalanced = isBalanced(root.left);
		boolean rightIsBalanced = isBalanced(root.right);

		// The tree is balanced if current subtree is balanced and both left and right
		// subtrees are balanced
		return currentIsBalanced && leftIsBalanced && rightIsBalanced;
	}

// Method to build a binary tree based on user input
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

// Main method for testing
	public static void main(String[] args) {
		Check_For_Balaned_Tree solution = new Check_For_Balaned_Tree();
		Node root = solution.buildTree();

		boolean balanced = solution.isBalanced(root);
		if (balanced) {
			System.out.println("The tree is height balanced.");
		} else {
			System.out.println("The tree is not height balanced.");
		}
	}
}