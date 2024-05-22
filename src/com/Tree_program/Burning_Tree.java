package com.Tree_program;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Burning_Tree {
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

    public static int minTime(Node root, int target) {
        // Your code goes here
        // Algorithms:
        // Create nodeToParent mapping
        // Find target node
        // Burn the tree in min time

        HashMap<Node, Node> nodeToParent = new HashMap<>();
        Node targetNode = createParentMapping(root, target, nodeToParent);
        int ans = burnTree(targetNode, nodeToParent);

        return ans;
    }

    public static Node createParentMapping(Node root, int target, Map<Node, Node> nodeToParent) {
        // Here is the value is null
        Node res = null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        nodeToParent.put(root, null);

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if (front.data == target) {
                res = front;
            }

            if (front.left != null) {
                nodeToParent.put(front.left, front);
                queue.add(front.left);
            }
            if (front.right != null) {
                nodeToParent.put(front.right, front);
                queue.add(front.right);
            }
        }
        return res;
    }

    public static int burnTree(Node root, Map<Node, Node> nodeToParent) {
        // Visited array
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        visited.put(root, true);

        int ans = 0;
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // Processing the neighbour nodes
                Node front = queue.poll();

                if (front.left != null && !visited.containsKey(front.left)) {
                    flag = true;
                    queue.add(front.left);
                    visited.put(front.left, true);
                }

                if (front.right != null && !visited.containsKey(front.right)) {
                    flag = true;
                    queue.add(front.right);
                    visited.put(front.right, true);
                }

                if (nodeToParent.get(front) != null && !visited.containsKey(nodeToParent.get(front))) {
                    flag = true;
                    queue.add(nodeToParent.get(front));
                    visited.put(nodeToParent.get(front), true);
                }
            }

            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Burning_Tree obj = new Burning_Tree();
        Node root = obj.buildTree();
        System.out.println(obj.minTime(root, 7));
    }
}

/*
 			Optimized code
 			package com.Tree_program;

import java.util.*;

public class Burning_Tree {
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

    public static int minTime(Node root, int target) {
        // Create nodeToParent mapping and find the target node
        HashMap<Node, Node> nodeToParent = new HashMap<>();
        Node targetNode = createParentMapping(root, target, nodeToParent);
        return burnTree(targetNode, nodeToParent);
    }

    private static Node createParentMapping(Node root, int target, Map<Node, Node> nodeToParent) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        nodeToParent.put(root, null);
        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.data == target) {
                targetNode = currentNode;
            }

            if (currentNode.left != null) {
                nodeToParent.put(currentNode.left, currentNode);
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                nodeToParent.put(currentNode.right, currentNode);
                queue.add(currentNode.right);
            }
        }
        return targetNode;
    }

    private static int burnTree(Node targetNode, Map<Node, Node> nodeToParent) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burnedNewNodes = false;

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    queue.add(currentNode.left);
                    visited.add(currentNode.left);
                    burnedNewNodes = true;
                }

                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    queue.add(currentNode.right);
                    visited.add(currentNode.right);
                    burnedNewNodes = true;
                }

                Node parentNode = nodeToParent.get(currentNode);
                if (parentNode != null && !visited.contains(parentNode)) {
                    queue.add(parentNode);
                    visited.add(parentNode);
                    burnedNewNodes = true;
                }
            }

            if (burnedNewNodes) {
                time++;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Burning_Tree obj = new Burning_Tree();
        Node root = obj.buildTree();
        System.out.println("Enter the target node: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println("Minimum time to burn the tree: " + minTime(root, target));
    }
}

  
  This version maintains the O(N) time complexity and O(height of tree) auxiliary
   space complexity while being more readable and efficient
  
 */
*/