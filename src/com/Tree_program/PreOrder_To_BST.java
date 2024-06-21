package com.Tree_program;

import java.util.ArrayList;

public class PreOrder_To_BST {
    static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static BinaryTreeNode<Integer> preorderToBST(ArrayList<Integer> preorder) {
        int mini = Integer.MIN_VALUE;
        int maxi = Integer.MAX_VALUE;
        // Using an array for the index to make it mutable
        int[] index = {0};
        return solve(preorder, mini, maxi, index);
    }

    public static BinaryTreeNode<Integer> solve(ArrayList<Integer> preorder, int mini, int maxi, int[] index) {
        if (index[0] >= preorder.size()) {
            return null;
        }

        int val = preorder.get(index[0]);

        // If the current value does not lie in the range, return null
        if (val < mini || val > maxi) {
            return null;
        }

        // Increment the index as we are using the current value
        index[0]++;

        // Create the root node for the current value
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(val);

        // Construct the left and right subtrees recursively
        root.left = solve(preorder, mini, val, index);
        root.right = solve(preorder, val, maxi, index);

        return root;
    }

    public static void printInOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Sample input
        ArrayList<Integer> preorder = new ArrayList<>();
        preorder.add(10);
        preorder.add(4);
        preorder.add(3);
        preorder.add(7);
        preorder.add(40);
        preorder.add(55);

        BinaryTreeNode<Integer> root = preorderToBST(preorder);

        // Print in-order traversal of the constructed BST
        printInOrder(root);
    }
}
