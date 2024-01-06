package com.Trees_Udemy_Course;

public class TreeTraversal_Main {
	public static void main(String[] args) {

		TreeTraversal  myBST = new TreeTraversal();

		myBST.insert(47);
		myBST.insert(21);
		myBST.insert(76);
		myBST.insert(18);
		myBST.insert(27);
		myBST.insert(52);
		myBST.insert(82);

		System.out.println("\nBreadth First Search:");
		System.out.println(myBST.BFS());

		/*
		 * EXPECTED OUTPUT: ---------------- Breadth First Search: [47, 21, 76, 18, 27,
		 * 52, 82]
		 * 
		 */

	}

}
