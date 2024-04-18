package com.Tree_program;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Binary_Tree {
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
        System.out.println("Enter the data for inserting in left node " + data);
        root.left = buildTree();

        // Build right subtree
        System.out.println("Enter the data for inserting in right node " + data);
        root.right = buildTree();

        return root; // Return the constructed subtree
    }

    void levelOrderTraversal(Node root) {
        if (root == null) {
            return; // If the tree is empty
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
    
    
    //Inorder Traversal
    
    public void inorder(Node root)
    {
    	//base cases
    	if(root == null)
    	{
    		return;
    	}
    	
    	// LNR
    	inorder(root.left);
    	System.out.print(root.data+ " ");
    	inorder(root.right);
    }
    public static void main(String[] args) {
        Binary_Tree obj = new Binary_Tree();
        Node root = obj.buildTree(); // Construct the binary tree and assign the returned root

        //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        
        if (root != null) {
            // Level order traversal
            System.out.println("Printing the levelOrder traversal output:");
            obj.levelOrderTraversal(root);
        } else {
            System.out.println("Binary tree is empty.");
        }
        System.out.println();
        System.out.println("Inorder Traversal : ");
        obj.inorder(root);
    }
}