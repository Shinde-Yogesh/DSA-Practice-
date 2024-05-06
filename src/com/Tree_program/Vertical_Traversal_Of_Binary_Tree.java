package com.Tree_program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Vertical_Traversal_Of_Binary_Tree {
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class QueueObj {
		Node node;
		int hd;

		QueueObj(Node node, int hd) {
			this.node = node;
			this.hd = hd;
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
		System.out.println("Enter the data for inserting in left " + data);
		root.left = buildTree();

		// Build right subtree
		System.out.println("Enter the data for inserting in right  " + data);
		root.right = buildTree();

		return root; // Return the constructed subtree
	}

	// Function to find the vertical order traversal of Binary Tree.
	static ArrayList<Integer> verticalOrder(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		Queue<QueueObj> queue = new LinkedList<>();
		queue.add(new QueueObj(root, 0));

		while (!queue.isEmpty()) {
			QueueObj temp = queue.poll();
			Node node = temp.node;
			int hd = temp.hd;

			if (!map.containsKey(hd))
				map.put(hd, new ArrayList<Integer>());
			map.get(hd).add(node.data);

			if (node.left != null)
				queue.add(new QueueObj(node.left, hd - 1));
			if (node.right != null)
				queue.add(new QueueObj(node.right, hd + 1));
		}

		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> list = entry.getValue();
			for (int i = 0; i < list.size(); i++)
				result.add(list.get(i));
		}
		return result;
	}
	public static void main(String[] args) {
		Vertical_Traversal_Of_Binary_Tree obj = new Vertical_Traversal_Of_Binary_Tree();
		Node root = obj.buildTree();
		System.out.println(verticalOrder(root));
	}
}
