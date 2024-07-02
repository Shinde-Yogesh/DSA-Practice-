package com.Tree_program;


public class MergeSortedDLL {
static class TreeNode {
	    int val;
	    TreeNode left, right;

	    TreeNode(int val) {
	        this.val = val;
	        this.left = this.right = null;
	    }
	}

    TreeNode mergeLinkedList(TreeNode head1, TreeNode head2) {
        TreeNode head = null;
        TreeNode tail = null;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (head == null) {
                    head = head1;
                    tail = head1;
                    head1 = head1.right;
                } else {
                    tail.right = head1;
                    head1.left = tail;
                    tail = head1;
                    head1 = head1.right;
                }
            } else {
                if (head == null) {
                    head = head2;
                    tail = head2;
                    head2 = head2.right;
                } else {
                    tail.right = head2;
                    head2.left = tail;
                    tail = head2;
                    head2 = head2.right;
                }
            }
        }
        
        // Attach remaining nodes
        while (head1 != null) {
            tail.right = head1;
            head1.left = tail;
            tail = head1;
            head1 = head1.right;
        }
        
        while (head2 != null) {
            tail.right = head2;
            head2.left = tail;
            tail = head2;
            head2 = head2.right;
        }
        
        return head;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode head1 = new TreeNode(1);
        head1.right = new TreeNode(3);
        head1.right.left = head1;
        head1.right.right = new TreeNode(5);
        head1.right.right.left = head1.right;

        TreeNode head2 = new TreeNode(2);
        head2.right = new TreeNode(4);
        head2.right.left = head2;
        head2.right.right = new TreeNode(6);
        head2.right.right.left = head2.right;

        MergeSortedDLL merger = new MergeSortedDLL();
        TreeNode mergedHead = merger.mergeLinkedList(head1, head2);

        // Print the merged DLL
        TreeNode current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}
