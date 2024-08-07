package com.Tree_program;
/*
public class BST_Into_Sorted_DLL {
	
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	class Wrapper {
		TreeNode head;
	}

	void convertaIntoSortedDll(TreeNode root, Wrapper headWrapper) {
		// base case
		if (root == null) {
			return;
		}

		convertaIntoSortedDll(root.right, headWrapper);

		root.right = headWrapper.head;

		if (headWrapper.head != null) {
			headWrapper.head.left = root;
		}

		headWrapper.head = root;

		convertaIntoSortedDll(root.left, headWrapper);
	}

	TreeNode bstToDll(TreeNode root) {
		Wrapper headWrapper = new Wrapper();
		convertaIntoSortedDll(root, headWrapper);
		return headWrapper.head;
	}
	public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        BST_Into_Sorted_DLL converter = new BST_Into_Sorted_DLL();
        TreeNode head = converter.bstToDll(root);

        // Print the DLL
        TreeNode current = head;
        while (current != null) {
            System.out.print(current.val+" "+"->");
            current = current.right;
        }
        System.out.println("DLL");
    }
}
*/
//Approach 2
	
	public class BST_Into_Sorted_DLL {
		static class TreeNode {
		    int val;
		    TreeNode left, right;

		    TreeNode(int val) {
		        this.val = val;
		        this.left = this.right = null;
		    }
		}

	    void convertaIntoSortedDll(TreeNode root, TreeNode[] headRef) {
	        // base case
	        if (root == null) {
	            return;
	        }
	        
	        // Convert the right subtree
	        convertaIntoSortedDll(root.right, headRef);
	        
	        // Insert the root node into the DLL
	        root.right = headRef[0];
	        
	        if (headRef[0] != null) {
	            headRef[0].left = root;
	        }
	        
	        // Update headRef to the current node
	        headRef[0] = root;
	        
	        // Convert the left subtree
	        convertaIntoSortedDll(root.left, headRef);
	    }
	    
	    TreeNode bstToDll(TreeNode root) {
	        TreeNode[] headRef = new TreeNode[1];
	        convertaIntoSortedDll(root, headRef);
	        return headRef[0];
	    }

	    public static void main(String[] args) {
	        // Example usage
	        TreeNode root = new TreeNode(10);
	        root.left = new TreeNode(6);
	        root.right = new TreeNode(14);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(8);
	        root.right.left = new TreeNode(12);
	        root.right.right = new TreeNode(16);

	        BST_Into_Sorted_DLL converter = new BST_Into_Sorted_DLL();
	        TreeNode head = converter.bstToDll(root);

	        // Print the DLL
	        TreeNode current = head;
	        while (current != null) {
	            System.out.print(current.val + " ");
	            current = current.right;
	        }
	    }
	}
