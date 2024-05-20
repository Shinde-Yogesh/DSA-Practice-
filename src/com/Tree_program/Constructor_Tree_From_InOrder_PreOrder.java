package com.Tree_program;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Constructor_Tree_From_InOrder_PreOrder {
	/*
	 * Solution 1 static class Node { int data; Node left; Node right;
	 * 
	 * // Constructor public Node(int data) { this.data = data; this.left = null;
	 * this.right = null; } }
	 * 
	 * static int preOrderIndex = 0;
	 * 
	 * public static Node buildTree(int inorder[], int preorder[], int n) {
	 * preOrderIndex = 0; return solve(inorder, preorder, 0, n - 1, n); }
	 * 
	 * private static Node solve(int[] inorder, int[] preorder, int inOrderStart,
	 * int inOrderEnd, int n) { // Base case if (preOrderIndex >= n || inOrderStart
	 * > inOrderEnd) { return null; }
	 * 
	 * int element = preorder[preOrderIndex++]; Node root = new Node(element); int
	 * position = findPosition(inorder, inOrderStart, inOrderEnd, element);
	 * 
	 * // Recursively build left and right subtrees root.left = solve(inorder,
	 * preorder, inOrderStart, position - 1, n); root.right = solve(inorder,
	 * preorder, position + 1, inOrderEnd, n); return root; }
	 * 
	 * private static int findPosition(int[] inorder, int inOrderStart, int
	 * inOrderEnd, int element) { for (int i = inOrderStart; i <= inOrderEnd; i++) {
	 * if (inorder[i] == element) { return i; } } return -1; }
	 * 
	 * private static void printPostorder(Node root) { if (root == null) { return; }
	 * printPostorder(root.left); printPostorder(root.right);
	 * System.out.print(root.data + " "); } public static void main(String[] args) {
	 * 
	 * // Example 1 int N1 = 4; int inorder1[] = {1, 6, 8, 7}; int preorder1[] = {1,
	 * 6, 7, 8}; Node root1 = buildTree(inorder1, preorder1, N1);
	 * printPostorder(root1); System.out.println(); }
	 */

	/*
	 * Solution 2 static class Node { int data; Node left, right;
	 * 
	 * public Node(int item) { data = item; left = right = null; } }
	 * 
	 * static class Index { int index = 0; }
	 * 
	 * public static Node buildTree(int inorder[], int preorder[], int n) { Index
	 * preIndex = new Index(); return solve(inorder, preorder, preIndex, 0, n - 1,
	 * n); }
	 * 
	 * private static Node solve(int[] inorder, int[] preorder, Index preIndex, int
	 * inOrderStart, int inOrderEnd, int n) { if (preIndex.index >= n ||
	 * inOrderStart > inOrderEnd) { return null; }
	 * 
	 * int element = preorder[preIndex.index++]; Node root = new Node(element); int
	 * position = findPosition(inorder, inOrderStart, inOrderEnd, element);
	 * 
	 * root.left = solve(inorder, preorder, preIndex, inOrderStart, position - 1,
	 * n); root.right = solve(inorder, preorder, preIndex, position + 1, inOrderEnd,
	 * n); return root; }
	 * 
	 * private static int findPosition(int[] inorder, int start, int end, int
	 * element) { for (int i = start; i <= end; i++) { if (inorder[i] == element) {
	 * return i; } } return -1; // This should not happen if the input arrays are
	 * correct }
	 * 
	 * public static void printPostOrder(Node node) { if (node == null) { return; }
	 * 
	 * printPostOrder(node.left); printPostOrder(node.right);
	 * System.out.print(node.data + " "); }
	 * 
	 * public static void main(String[] args) { int inorder1[] = {1, 6, 8, 7}; int
	 * preorder1[] = {1, 6, 7, 8}; int n1 = inorder1.length;
	 * 
	 * Node root1 = buildTree(inorder1, preorder1, n1); printPostOrder(root1); //
	 * Output: 8 7 6 1 System.out.println();
	 * 
	 * int inorder2[] = {3, 1, 4, 0, 5, 2}; int preorder2[] = {0, 1, 3, 4, 2, 5};
	 * int n2 = inorder2.length;
	 * 
	 * Node root2 = buildTree(inorder2, preorder2, n2); printPostOrder(root2); //
	 * Output: 3 4 1 5 2 0 System.out.println(); }
	 */

	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class Index {
		int index = 0;
	}

	public static Node buildTree(int inorder[], int preorder[], int n) {
		Index preIndex = new Index();
		Map<Integer, Queue<Integer>> inorderMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			inorderMap.putIfAbsent(inorder[i], new LinkedList<>());
			inorderMap.get(inorder[i]).offer(i);
		}
		return solve(inorder, preorder, preIndex, 0, n - 1, inorderMap);
	}

	private static Node solve(int[] inorder, int[] preorder, Index preIndex, int inOrderStart, int inOrderEnd,
			Map<Integer, Queue<Integer>> inorderMap) {
		if (preIndex.index >= preorder.length || inOrderStart > inOrderEnd) {
			return null;
		}

		int element = preorder[preIndex.index++];
		Node root = new Node(element);
		int position = inorderMap.get(element).poll(); // Get the correct position for this instance of element

		root.left = solve(inorder, preorder, preIndex, inOrderStart, position - 1, inorderMap);
		root.right = solve(inorder, preorder, preIndex, position + 1, inOrderEnd, inorderMap);
		return root;
	}

	public static void printPostOrder(Node node) {
		if (node == null) {
			return;
		}

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
	}

	public static void main(String[] args) {
		int inorder1[] = { 1, 6, 8, 7 };
		int preorder1[] = { 1, 6, 7, 8 };
		int n1 = inorder1.length;

		Node root1 = buildTree(inorder1, preorder1, n1);
		printPostOrder(root1); // Output: 8 7 6 1
		System.out.println();

		int inorder2[] = { 3, 1, 4, 0, 5, 2 };
		int preorder2[] = { 0, 1, 3, 4, 2, 5 };
		int n2 = inorder2.length;

		Node root2 = buildTree(inorder2, preorder2, n2);
		printPostOrder(root2); // Output: 3 4 1 5 2 0
		System.out.println();
	}
}
