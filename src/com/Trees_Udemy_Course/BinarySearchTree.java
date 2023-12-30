package com.Trees_Udemy_Course;

public class BinarySearchTree {
	 Node root;
	
	class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value)
		{
			this.value = value;
		}
	}
	
	// for the insert the node
	public boolean insert(int value)
	{
		Node newNode = new Node(value);
		
		// base case
		if(root == null)
		{
			root =newNode;
			return true;
		}
		
		//if not then
		Node temp = root;
		while(true)
		{
			// IMP case if inserting value same as node in Tree return false
			if(newNode.value == temp.value) return false;
			
			//for left condition
			if(newNode.value < temp.value)
			{
				// if the left node is empty then 
				if(temp.left == null)
				{
					temp.left = newNode;
					return true;
				}
				//else the temp move the next node and process goes on until result not fount
				temp = temp.left;
			}else
			{
				if(temp.right == null)
				{
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
		}
	}
	

}
