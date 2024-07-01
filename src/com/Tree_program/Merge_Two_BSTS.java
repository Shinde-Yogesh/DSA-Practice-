package com.Tree_program;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class Merge_Two_BSTS {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // Perform inorder traversal to get sorted elements of both BSTs
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        
        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }
    
    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.data);
        inorderTraversal(node.right, list);
    }
    
    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        
        // Merge the two lists
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        
        // Add remaining elements from list1
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        
        // Add remaining elements from list2
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        
        return mergedList;
    }

    public static void main(String[] args) {
        // Sample Input 1
        TreeNode root1_1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode root1_2 = new TreeNode(4);

        List<Integer> result1 = mergeBST(root1_1, root1_2);
        System.out.println(result1); // Output: [1, 2, 3, 4]

        // Sample Input 2
        TreeNode root2_1 = new TreeNode(4, new TreeNode(2, null, new TreeNode(3)), new TreeNode(7));
        TreeNode root2_2 = new TreeNode(5, new TreeNode(1), new TreeNode(7));

        List<Integer> result2 = mergeBST(root2_1, root2_2);
        System.out.println(result2); // Output: [1, 2, 3, 4, 5, 7, 7]
    }
}
