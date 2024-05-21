package com.Tree_program;

import java.util.HashMap;

public class Create_BT_preOrder_postOrder_Traversal {
	/* Solution 1
	static class Node {
	        int data;
	        Node left, right;

	        public Node(int item) {
	            data = item;
	            left = right = null;
	        }
	    }

	    static class Index {
	        int index;
	    }

	    public static Node buildTree(int inorder[], int postorder[], int n) {
	        Index postIndex = new Index();
	        postIndex.index = n - 1;
	        Map<Integer, Integer> inorderMap = new HashMap<>();
	        for (int i = 0; i < n; i++) {
	            inorderMap.put(inorder[i], i);
	        }
	        return buildTreeRec(inorder, postorder, 0, n - 1, postIndex, inorderMap);
	    }

	    private static Node buildTreeRec(int[] inorder, int[] postorder, int inStart, int inEnd, Index postIndex, Map<Integer, Integer> inorderMap) {
	        if (inStart > inEnd) {
	            return null;
	        }

	        int element = postorder[postIndex.index--];
	        Node root = new Node(element);

	        if (inStart == inEnd) {
	            return root;
	        }

	        int inIndex = inorderMap.get(element);

	        root.right = buildTreeRec(inorder, postorder, inIndex + 1, inEnd, postIndex, inorderMap);
	        root.left = buildTreeRec(inorder, postorder, inStart, inIndex - 1, postIndex, inorderMap);

	        return root;
	    }

	    public static void printPreOrder(Node node) {
	        if (node == null) {
	            return;
	        }

	        System.out.print(node.data + " ");
	        printPreOrder(node.left);
	        printPreOrder(node.right);
	    }

	    public static void main(String[] args) {
	        int inorder1[] = {4, 8, 2, 5, 1, 6, 3, 7};
	        int postorder1[] = {8, 4, 5, 2, 6, 7, 3, 1};
	        int n1 = inorder1.length;

	        Node root1 = buildTree(inorder1, postorder1, n1);
	        printPreOrder(root1); // Output: 1 2 4 8 5 3 6 7
	        System.out.println();

	        int inorder2[] = {9, 5, 2, 3, 4};
	        int postorder2[] = {5, 9, 3, 4, 2};
	        int n2 = inorder2.length;

	        Node root2 = buildTree(inorder2, postorder2, n2);
	        printPreOrder(root2); // Output: 2 9 5 4 3
	        System.out.println();
	    }
	    
	    */
	
	
	static class Node {
	    int val;
	    Node left;
	    Node right;
	    Node(int x) { val = x; }
	}

	 private HashMap<Integer, Integer> inorderMap;
	    private int postIndex;

	    public Node buildTree(int[] inorder, int[] postorder, int n) {
	        inorderMap = new HashMap<>();
	        for (int i = 0; i < n; i++) {
	            inorderMap.put(inorder[i], i);
	        }
	        postIndex = n - 1;
	        return buildTreeRecursive(inorder, postorder, 0, n - 1);
	    }

	    private Node buildTreeRecursive(int[] inorder, int[] postorder, int inorderStart, int inorderEnd) {
	        if (inorderStart > inorderEnd) {
	            return null;
	        }
	        
	        int rootVal = postorder[postIndex--];
	        Node root = new Node(rootVal);
	        
	        int inorderIndex = inorderMap.get(rootVal);
	        
	        // Recursively build the right subtree first because we are decrementing postIndex
	        root.right = buildTreeRecursive(inorder, postorder, inorderIndex + 1, inorderEnd);
	        root.left = buildTreeRecursive(inorder, postorder, inorderStart, inorderIndex - 1);
	        
	        return root;
	    }
	    
	    // Function to print preorder traversal
	    public void printPreorder(Node node) {
	        if (node == null) {
	            return;
	        }
	        System.out.print(node.val + " ");
	        printPreorder(node.left);
	        printPreorder(node.right);
	    }

	    // Driver code
	    public static void main(String[] args) {
	    	Create_BT_preOrder_postOrder_Traversal sol = new Create_BT_preOrder_postOrder_Traversal();
	        int n = 8;
	        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
	        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};
	        Node root = sol.buildTree(inorder, postorder, n);
	        sol.printPreorder(root); // Expected Output: 1 2 4 8 5 3 6 7
	    }
}
