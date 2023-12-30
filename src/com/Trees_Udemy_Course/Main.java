package com.Trees_Udemy_Course;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
//		System.out.println("root : "+ tree.root);
		tree.insert(47);
		tree.insert(21);
		tree.insert(76);
		tree.insert(18);
		tree.insert(52);
		tree.insert(82);
		
		tree.insert(27);
		
		System.out.println(tree.root.left.right.value);
	}
	
}
