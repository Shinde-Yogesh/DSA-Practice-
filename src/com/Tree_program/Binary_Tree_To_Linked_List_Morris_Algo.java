package com.Tree_program;

import java.util.Scanner;

public class Binary_Tree_To_Linked_List_Morris_Algo {
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
		System.out.println("Enter the data: ");
		int data = sc.nextInt();

		if (data == -1) {
			return null; // Return null to indicate no node
		}

		Node root = new Node(data); // Create the root node

		// Build left subtree
		System.out.println("Enter the node for inserting in left " + data);
		root.left = buildTree();

		// Build right subtree
		System.out.println("Enter the node for inserting in right " + data);
		root.right = buildTree();

		return root; // Return the constructed subtree
	}

	public Node flatten(Node root) {
		// temp node
		Node curr = root;

		while (curr != null) {

			if (curr.left != null) {
				// creating one predecessor (that means one left and goes right until not equal
				// to null)
				Node pred = curr.left;

				while (pred.right != null) {
					pred = pred.right;
				}
				pred.right = curr.right;
				curr.right = curr.left;
			}
			curr = curr.right;
		}

		// for left null
		curr = root;
		while (curr != null) {
			curr.left = null;
			curr = curr.right;
		}
		return root;
	}

	void MorrisTraversal(Node root) {
		Node current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/*
				 * Find the inorder predecessor of current
				 */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/*
				 * Make current as right child of its inorder predecessor
				 */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in the 'if' part to restore the original tree i.e.,
				 * fix the right child of predecessor
				 */
				else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				} /*
					 * End of if condition pre->right == NULL
					 */

			} /* End of if condition current->left == NULL */

		} /* End of while */
	}

	public static void main(String[] args) {
		Binary_Tree_To_Linked_List_Morris_Algo obj = new Binary_Tree_To_Linked_List_Morris_Algo();
		Node root = obj.buildTree();
		Node flatenRoot = obj.flatten(root);
		obj.MorrisTraversal(flatenRoot);

	}
}

/*	
			
							 	1
						       / \
						      3   4
						         /
						        2
						         \
						          5 
						Output : 
						1 3 4 2 5  
						Explanation : 
						After flattening, the tree looks 
						like this 
						     1
						      \
						       3
						        \
						         4
						          \
						           2
						            \ 
						             5 
						Here, left of each node points 
						to NULL and right contains the 
						next node in preorder.The inorder 
						traversal of this flattened tree 
						is 1 3 4 2 5.

*/