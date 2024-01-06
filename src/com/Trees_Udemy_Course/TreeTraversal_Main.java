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

		System.out.println("\nDeapth Search:");
		System.out.println(myBST.DFSPreOrder());

		/*
		 * EXPECTED OUTPUT: ---------------- Deapth Search:
			[47, 21, 18, 27, 76, 52, 82]
		 * 
		 */

	}

}
