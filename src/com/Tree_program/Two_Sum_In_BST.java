package com.Tree_program;

import java.util.ArrayList;

public class Two_Sum_In_BST {
	static class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
	public static boolean twoSumInBST(BinaryTreeNode<Integer> root, int target) {
		ArrayList<Integer>inorderDataCollect = new ArrayList<>();
		ArrayList<Integer> inorderValue = inOrder(root, inorderDataCollect);
		
		int i = 0;
		int j = inorderValue.size()-1;
		
		while(i<j)
		{
			int sum = inorderValue.get(i) + inorderValue.get(j);
			if(sum == target)
			{
				return true;
			}
			else if (sum > target)
			{
				j--;
			}
			else
			{
				i++;
			}
		}
		return false;
	}
	public static ArrayList<Integer> inOrder(BinaryTreeNode<Integer> root,ArrayList<Integer>inorderValue)
	{
		if(root == null)
		{
			return null;
		}
		
		inOrder(root.left, inorderValue);
		inorderValue.add(root.data);
		inOrder(root.right, inorderValue);
		
		return inorderValue;
	}
	 public static void main(String[] args) {
	        // Construct the binary tree
	        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
	        root.left = new BinaryTreeNode<>(5);
	        root.right = new BinaryTreeNode<>(15);
	        root.left.left = new BinaryTreeNode<>(3);
	        root.left.right = new BinaryTreeNode<>(7);
	        root.right.left = new BinaryTreeNode<>(12);
	        root.right.right = new BinaryTreeNode<>(18);

	        // Test the twoSumInBST function
	        int target = 22;
	        boolean result = twoSumInBST(root, target);
	        System.out.println("Two elements with sum " + target + ": " + result);

	        target = 10;
	        result = twoSumInBST(root, target);
	        System.out.println("Two elements with sum " + target + ": " + result);

	        target = 27;
	        result = twoSumInBST(root, target);
	        System.out.println("Two elements with sum " + target + ": " + result);
	    }
}



/* 		
 * 				Binary Tree
 * 				       10
				      /  \
				     5    15
				    / \   / \
				   3   7 12 18

*/

