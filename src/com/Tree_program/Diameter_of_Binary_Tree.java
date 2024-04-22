package com.Tree_program;

import java.util.Scanner;
/*
public class Diameter_of_Binary_Tree {

	 
	 	Working code but TLE In GFG
	 	
	 	
	 	
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
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

	int diameter(Node root) {
		// Your code here

		// base case
		if (root == null) {
			return 0;
		}
		int option1 = diameter(root.left);
		int option2 = diameter(root.right);
		int option3 = height(root.left) + height(root.right) + 1;

		int ans = Math.max(option1, Math.max(option2, option3));
		return ans;
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
		Diameter_of_Binary_Tree obj = new Diameter_of_Binary_Tree();
		Node root = obj.buildTree();
		System.out.println("The Height of Tree : "+obj.height(root));
		System.out.println("The Diameter of Tree : "+obj.diameter(root));

	}

}
*/




class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Diameter_of_Binary_Tree {
    private static class Result {
        int diameter;
        int height;

        Result(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int diameter(Node root) {
        return diameterAndHeight(root).diameter;
    }

    private Result diameterAndHeight(Node node) {
        if (node == null) {
            return new Result(0, 0);
        }

        Result leftResult = diameterAndHeight(node.left);
        Result rightResult = diameterAndHeight(node.right);

        // Height of current node
        int currentHeight = Math.max(leftResult.height, rightResult.height) + 1;

        // Diameter passing through the current node
        int diameterThroughCurrent = leftResult.height + rightResult.height + 1;

        // Maximum diameter found so far
        int maxDiameter = Math.max(diameterThroughCurrent, Math.max(leftResult.diameter, rightResult.diameter));

        return new Result(maxDiameter, currentHeight);
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
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        Diameter_of_Binary_Tree tree = new Diameter_of_Binary_Tree();
        Node buildTree = tree.buildTree();
        int treeDiameter = tree.diameter(buildTree);
        System.out.println("Diameter of the tree is: " + treeDiameter); // Output: 6
    }
}
