package com.Tree_program;

import java.util.ArrayList;
import java.util.Scanner;

public class Left_View_in_Binary_tree {
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
	 ArrayList<Integer> leftView(Node root)
	    {
	      ArrayList<Integer> ans = new ArrayList<Integer>();
	    
	      solve(root, ans, 0);
	      return ans;
	    }
	private void solve(Node root, ArrayList<Integer> ans, int level) {
		if(root == null)
		{
			return;
		}
		
		//if the list size equval to the level then it's new node
		if(ans.size() == level)
		{
			ans.add(root.data);
		}
		solve(root.left, ans, level+1);
		solve(root.right, ans, level+1);
	}
	public static void main(String[] args) {
		Left_View_in_Binary_tree obj =new Left_View_in_Binary_tree();
		Node root = obj.buildTree();
		System.out.println(obj.leftView(root));
	}
	
}
