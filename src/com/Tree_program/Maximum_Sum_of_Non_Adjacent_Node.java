package com.Tree_program;

import java.util.Scanner;

import com.Tree_program.Lowest_Common_Ancestor.Node;

public class Maximum_Sum_of_Non_Adjacent_Node {

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
/*   Code work 
	// Pair storing maximum sum for current node in 2 cases :
	// 1. If current node is included
	// 2. if current node in excluded
	
	static class Pair {
		int include;
		int exclude;

		Pair(int include, int exclude) {
			this.include = include;
			this.exclude = exclude;
		}
	}

	// Function to return the maximum sum of non-adjacent nodes.
	int getMaxSum(Node root) {
		Pair ans = helper(root);
		return Math.max(ans.include, ans.exclude);
	}

	static Pair helper(Node root) {
		if (root == null)
			return new Pair(0, 0);

		Pair left = helper(root.left);
		Pair right = helper(root.right);

		Pair curr = new Pair(0, 0);
		// if current node is included then it's childred have to be excluded
		curr.include = root.data + left.exclude + right.exclude;
		// if current node is excluded, then we add : max sum from each of it's child by
		// excluding and including child
		curr.exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

		return curr;
	}
*/
	//second approach
	public int getMaxSum(Node root) {
        int[] result = maxSumHelper(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] maxSumHelper(Node node) {
        if (node == null)
            return new int[]{0, 0};
        
        int[] left = maxSumHelper(node.left);
        int[] right = maxSumHelper(node.right);
        
        int include = node.data + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{include, exclude};
    }
	public static void main(String[] args) {
		Maximum_Sum_of_Non_Adjacent_Node obj = new Maximum_Sum_of_Non_Adjacent_Node();
		Node root = obj.buildTree();
		System.out.println(obj.getMaxSum(root));
	}
}
