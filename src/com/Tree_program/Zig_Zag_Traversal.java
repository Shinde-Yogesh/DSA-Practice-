package com.Tree_program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Zig_Zag_Traversal {
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
	
	    public ArrayList<Integer> zigZagTraversal(Node root) {
	        ArrayList<Integer> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }

	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);
	        boolean leftToRight = true; // Flag for the current traversal direction

	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            ArrayList<Integer> levelNodes = new ArrayList<>();

	            for (int i = 0; i < size; i++) {
	                Node current = queue.poll();

	                // Determine the position to add based on the traversal direction
	                if (leftToRight) {
	                    levelNodes.add(current.data); // Add normally for left to right
	                } else {
	                    levelNodes.add(0, current.data); // Insert at the beginning for right to left
	                }

	                // Add children to the queue
	                if (current.left != null) {
	                    queue.add(current.left);
	                }
	                if (current.right != null) {
	                    queue.add(current.right);
	                }
	            }

	            // Add current level nodes to the result
	            result.addAll(levelNodes);

	            // Toggle the direction for the next level
	            leftToRight = !leftToRight;
	        }

	        return result;
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
		public static void main(String[] args) {
			Zig_Zag_Traversal obj = new Zig_Zag_Traversal();
			Node root = obj.buildTree();
			System.out.println(obj.zigZagTraversal(root));
		}
}
