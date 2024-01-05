package com.Trees_Udemy_Course;

public class Main {

	public static void main(String[] args) {
		/*BinarySearchTree tree = new BinarySearchTree();
//		System.out.println("root : "+ tree.root);
		tree.insert(47);
		tree.insert(21);
		tree.insert(76);
		tree.insert(18);
		tree.insert(52);
		tree.insert(82);
		tree.insert(27);
		
		
//		System.out.println(tree.contains(27));
//		System.out.println(tree.contains(17));
//		
		//using recursive way
		System.out.println("\nBST Contains 27");
		System.out.println(tree.rContains(27));
		
		System.out.println("\nBST Contains 17");
		System.out.println(tree.rContains(17));
//		System.out.println(tree.root.left.right.value);
		
		*/
		
		//for insertion method
		BinarySearchTree tree = new BinarySearchTree();
		tree.rInsert(2);
		tree.rInsert(1);
		tree.rInsert(3);
		
		System.out.println("\nRoot: "+tree.root.value);
		System.out.println("\nRoot -> Left: "+tree.root.left.value);
		System.out.println("\nRoot: -> Right "+tree.root.right.value);
	}
	
}
/*
//What you know
Binary Search Trees always have a better Big O than Linked Lists: false
Binary Search Trees use divide and conquer: true
Adding an item to a Binary Search Tree is always log n: false */