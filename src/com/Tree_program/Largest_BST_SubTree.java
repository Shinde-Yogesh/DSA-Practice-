package com.Tree_program;

public class Largest_BST_SubTree {
	static class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    
	    TreeNode() {
	        this.data = 0;
	        this.left = null;
	        this.right = null;
	    }
	    
	    TreeNode(int data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	    
	    TreeNode(int data, TreeNode left, TreeNode right) {
	        this.data = data;
	        this.left = left;
	        this.right = right;
	    }
	}

	 static class SubtreeInfo {
	        int size; // Size of the subtree
	        int min;  // Minimum value in the subtree
	        int max;  // Maximum value in the subtree
	        boolean isBST; // Whether the subtree is a BST
	        
	        SubtreeInfo(int size, int min, int max, boolean isBST) {
	            this.size = size;
	            this.min = min;
	            this.max = max;
	            this.isBST = isBST;
	        }
	    }

	    public static int largestBST(TreeNode root) {
	        return largestBSTHelper(root).size;
	    }

	    private static SubtreeInfo largestBSTHelper(TreeNode root) {
	        if (root == null) {
	            return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
	        }

	        SubtreeInfo left = largestBSTHelper(root.left);
	        SubtreeInfo right = largestBSTHelper(root.right);

	        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
	            int size = 1 + left.size + right.size;
	            int min = Math.min(root.data, left.min);
	            int max = Math.max(root.data, right.max);
	            return new SubtreeInfo(size, min, max, true);
	        } else {
	            return new SubtreeInfo(Math.max(left.size, right.size), 0, 0, false);
	        }
	    }

	    public static void main(String[] args) {
	        // Sample Test Cases
	        TreeNode root1 = new TreeNode(2);
	        root1.left = new TreeNode(1);
	        root1.right = new TreeNode(3);

	        TreeNode root2 = new TreeNode(50);
	        root2.right = new TreeNode(20);
	        root2.right.right = new TreeNode(30);
	        root2.right.right.right = new TreeNode(40);
	        root2.right.right.right.right = new TreeNode(50);

	        System.out.println(largestBST(root1)); // Output: 3
	        System.out.println(largestBST(root2)); // Output: 4
	    }
}
