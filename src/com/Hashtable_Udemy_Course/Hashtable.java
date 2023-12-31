package com.Hashtable_Udemy_Course;

public class Hashtable {
	
	// for Node class
	class Node{
		String key ;
		int value;
		Node next;
		
		Node(String key,int value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	//for class constructor
	private int size = 7;
	private Node[] dataMap;
	
	public Hashtable()
	{
		dataMap = new Node[size];
	}
	
	//printing the element of hashtable
	public void printTable()
	{
		for(int i = 0; i<dataMap.length;i++)
		{
			System.out.println(i+":");
			Node temp = dataMap[i];
			while(temp != null)
			{
				System.out.println("  {" + temp.key + "= " +temp.value + "}");
				temp = temp.next;
			}
		}
	}
	
	//for hash value 
	public int hash(String key)
	{
		int hash = 0;
		char[] keyChars = key.toCharArray();
		for (int i = 0; i < keyChars.length; i++) {
			int asciiValue = keyChars[i];
			
			//here 23 is prime number
			hash = (hash + asciiValue * 23) % dataMap.length;
		}
		return hash;
	}
	
	//for set the value
	public void set(String key,int value)
	{
		int index = hash(key);
		
		//store the data in node
		Node newNode = new Node(key,value);
		if(dataMap[index] == null)
		{
			dataMap[index] = newNode;
		}else  //that means the node contains the value
		{
			Node temp = dataMap[index];
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
		}
				
	}

}
