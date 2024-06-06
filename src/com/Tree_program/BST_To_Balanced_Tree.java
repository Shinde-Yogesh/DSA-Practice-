package com.Tree_program;

import java.util.ArrayList;

public class BST_To_Balanced_Tree {
	 static class TreeNode<T> 
	    {
	       
	        T data;
	        TreeNode<T> left;
	        TreeNode<T> right;

	        TreeNode(T data) 
	        {
	            this.data = data;
	            left = null;
	            right = null;
	        }
	    };
	    
	   
	    public static ArrayList<Integer> inOrder(TreeNode<Integer> root, ArrayList<Integer> inorderValue) {
	        if (root == null) {
	            return inorderValue;
	        }

	        inOrder(root.left, inorderValue);
	        inorderValue.add(root.data);
	        inOrder(root.right, inorderValue);

	        return inorderValue;
	    }
	    public static TreeNode<Integer> balancedBst(TreeNode<Integer> root)
	    {
	    	// Collecting the in-order traversal of the BST
	        ArrayList<Integer> inorderDataCollect = new ArrayList<>();
	        ArrayList<Integer> inorderValue = inOrder(root, inorderDataCollect);

			return inorderToBST(0, inorderValue.size()-1, inorderValue);
	      
	    }
	    public static TreeNode<Integer> inorderToBST( int s, int e ,ArrayList<Integer> inorderValue)
	    {
	    	// base case
	    	if (s >e)
	    	{
	    		return null;
	    	}
	    	int mid = (s+e)/2;
	    	 TreeNode<Integer> root = new TreeNode<>(inorderValue.get(mid));
	    	 
	    	 root.left = inorderToBST(s, mid-1, inorderValue);
	    	 root.right = inorderToBST(mid+1, e, inorderValue);
	    	
			return root;
	    }
	    public static void printTree(TreeNode<Integer> root) {
	        if (root == null) {
	            return;
	        }
	        System.out.print(root.data + " ");
	        printTree(root.left);
	        printTree(root.right);
	    }
	    
	   public static void main(String[] args) {
		   TreeNode<Integer> root = new TreeNode<>(10);
	        root.left = new TreeNode<>(8);
	        root.left.left = new TreeNode<>(4);
	        root.left.left.left = new TreeNode<>(2);

	        root.right = new TreeNode<>(12);
	        root.right.right = new TreeNode<>(16);
	        root.right.right.right = new TreeNode<>(20);

	        System.out.println("Before the operation tree:");
	        printTree(root);
	        System.out.println();

	        TreeNode<Integer> balancedRoot = balancedBst(root);

	        System.out.println("After balancing the tree:");
	        printTree(balancedRoot);
	        System.out.println();
	       
	} 
}
