package com.Tree_program;

import java.util.ArrayList;

public class Flatten_From_BST_To_Sorted_LL {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Integer> inOrder(TreeNode<Integer> root, ArrayList<Integer> inorderValue) {
        if (root == null) {
            return inorderValue;
        }

        inOrder(root.left, inorderValue);
        inorderValue.add(root.data);
        inOrder(root.right, inorderValue);

        return inorderValue;
    }

    public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
        // Collecting the in-order traversal of the BST
        ArrayList<Integer> inorderDataCollect = new ArrayList<>();
        ArrayList<Integer> inorderValue = inOrder(root, inorderDataCollect);

        // Creating a dummy node to start building the new tree
        TreeNode<Integer> dummyNode = new TreeNode<>(-1);
        TreeNode<Integer> current = dummyNode;

        // Reconstructing the tree as a right-skewed tree
        for (int value : inorderValue) {
            current.right = new TreeNode<>(value);
            current = current.right;
        }

        // The right child of the dummy node is the new root of the right-skewed tree
        return dummyNode.right;
    }


    public static void main(String[] args) {
        Flatten_From_BST_To_Sorted_LL solution = new Flatten_From_BST_To_Sorted_LL();

        // Example BST construction
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(12);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(8);
        root.right.left = new TreeNode<>(11);
        root.right.right = new TreeNode<>(15);

        // Flatten the BST
        TreeNode<Integer> newRoot = flatten(root);

        // Print the flattened tree
        TreeNode<Integer> current = newRoot;
        while (current != null) {
            System.out.print(current.data+ " "+"->");
            current = current.right;
        }
        System.out.println("NULL");
    }

}
