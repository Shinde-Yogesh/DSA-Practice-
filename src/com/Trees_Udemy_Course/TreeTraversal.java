package com.Trees_Udemy_Course;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeTraversal {
	public class Queue<T> {
		private LinkedList<T> list = new LinkedList<>();

		public void add(T item) {
			list.addLast(item);
		}

		public T remove() {
			if (isEmpty()) {
				throw new IllegalStateException("Queue is empty");
			}
			return list.removeFirst();
		}

		public boolean isEmpty() {
			return list.isEmpty();
		}

		public int size() {
			return list.size();
		}
	}

	public Node root;

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		private Node(int value) {
			this.value = value;
		}
	}

	public boolean insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return true;
		}
		Node temp = root;
		while (true) {
			if (newNode.value == temp.value)
				return false;
			if (newNode.value < temp.value) {
				if (temp.left == null) {
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
		}
	}

	public boolean contains(int value) {
		if (root == null)
			return false;
		Node temp = root;
		while (temp != null) {
			if (value < temp.value) {
				temp = temp.left;
			} else if (value > temp.value) {
				temp = temp.right;
			} else {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer> BFS() {
		Node currentNode = root;
		Queue<Node> queue = new Queue<>(); // Use the generic Queue
		ArrayList<Integer> results = new ArrayList<>();
		queue.add(currentNode);

		while (!queue.isEmpty()) {
			currentNode = queue.remove();
			results.add(currentNode.value);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		return results;
	}

	// for the DFS
	public ArrayList<Integer> DFSPreOrder() {
		ArrayList<Integer> results = new ArrayList<>();

		class Traversal {
			public Traversal(Node currentNode) {
				results.add(currentNode.value);
				if (currentNode.left != null) {
					new Traversal(currentNode.left);
				}

				if (currentNode.right != null) {
					new Traversal(currentNode.right);
				}
			}
		}
		new Traversal(root);
		return results;
	}
}
