package com.Trees_Udemy_Course;

public class BinarySearchTree {
	Node root;

	class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

	// for the insert the node
	public boolean insert(int value) {
		Node newNode = new Node(value);

		// base case
		if (root == null) {
			root = newNode;
			return true;
		}

		// if not then
		Node temp = root;
		while (true) {
			// IMP case if inserting value same as node in Tree return false
			if (newNode.value == temp.value)
				return false;

			// for left condition
			if (newNode.value < temp.value) {
				// if the left node is empty then
				if (temp.left == null) {
					temp.left = newNode;
					return true;
				}
				// else the temp move the next node and process goes on until result not fount
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

	// for the node contain the value
	public boolean contains(int value) {
		if (root == null)
			return false;

		// for traveling the node
		Node temp = root;
		while (temp != null) {
			// for the base if less than move left
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

	// for the recursive BT
	private boolean rContains(Node currentNode, int value) {
		if (currentNode == null)
			return false;

		if (currentNode.value == value)
			return true;

		if (value < currentNode.value) {
			return rContains(currentNode.left, value);
		} else {
			return rContains(currentNode.right, value);
		}
	}

	public boolean rContains(int value) {
		return rContains(root, value);
	}

	// for the insert
	private Node rInsert(Node currentNode, int value) {
		if (currentNode == null)
			return new Node(value);

		if (value < currentNode.value) {
			currentNode.left = rInsert(currentNode.left, value);
		} else if (value > currentNode.value) {
			currentNode.right = rInsert(currentNode.right, value);
		}
		return currentNode;
	}

	public void rInsert(int value) {
		if (root == null)
			root = new Node(value);

		rInsert(root, value);
	}

	public int minValue(Node currentNode) {
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode.value;
	}

	// Node remove
	private Node deleteNode(Node currentNode, int value) {
		if (currentNode == null)
			return null;

		if (value < currentNode.value) {
			currentNode.left = deleteNode(currentNode.left, value);
		} else if (value > currentNode.value) {
			currentNode.right = deleteNode(currentNode.right, value);
		} else {
			if (currentNode.left == null && currentNode.right == null) {
				currentNode = null;
			} else if (currentNode.left == null) {
				currentNode = currentNode.right;
			} else if (currentNode.right == null) {
				currentNode = currentNode.left;
			} else {
				int subTreeMin = minValue(currentNode.right);
				currentNode.value = subTreeMin;
				currentNode.right = deleteNode(currentNode.right, subTreeMin);
			}
		}
		return currentNode;
	}

	public void deleteNode(int value) {
		deleteNode(root, value);
	}
}
