package com.LinkedList_Udemy_Course;

public class Get_Node_Index {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}
	// remove first element
		public Node removeFirst() {
			if (length == 0)
				return null;
			Node temp = head;
			head = head.next;
			temp.next = null;
			length--;
			if (length == 0) {
				tail = null;
			}
			return temp;
		}

		public Node removeLast() {
			if (length == 0) {
				return null;
			}

			Node temp = head;
			Node pre = head;

			while (temp.next != null) {
				pre = temp;
				temp = temp.next;
			}
			tail = pre;
			tail.next = null;
			length--;

			// if single node test case
			if (length == 0) {
				head = null;
				tail = null;
			}
			return temp;
		}


	public Get_Node_Index(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	public Node get(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
	
	public boolean set(int index, int value)
	{
		Node temp = get(index);
		if(temp != null)
		{
			temp.value = value;
			return true;
		}
		return false;
	}
	 public void prepend(int value) {
	        Node newNode = new Node(value);
	        if (length == 0) {
	            head = newNode;
	            tail = newNode;
	        } else {
	            newNode.next = head;
	            head = newNode;
	        }
	        length++;
	    }
	
	// Insert the node 
	public boolean insert(int index, int value)
	{
		if(index<0 || index>length) return false;
		if(index == 0)
		{
			prepend(value);
			return true;
		}
		if(index == length)
		{
			append(value);
			return true;
		}
		
		Node newNode = new Node(value);
		Node temp = get(index -1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
	return true;
	}
	
	//Remove the Node
	public Node remove(int index)
	{
		if(index < 0 || index >= length) return null;
		if(index == 0) return removeFirst();
		if(index == length-1) return removeLast();

	
	Node prev = get(index -1);
	Node temp = prev.next;
	
	prev.next = temp.next;
	temp.next = null;
	length--;
	return temp;
	
	
	}

	public void getLength() {
		System.out.println("Length : " + length);
	}

	// main method
	public static void main(String[] args) {
		Get_Node_Index myLinkedList = new Get_Node_Index(4);
		myLinkedList.append(5);
		myLinkedList.append(6);
		myLinkedList.append(7);
		myLinkedList.append(8);
		myLinkedList.getLength();
		
//		myLinkedList.printList();
//		myLinkedList.set(4,9);
		
		myLinkedList.printList();
//		myLinkedList.insert(1, 3);
		System.out.println("The remove node is : "+myLinkedList.remove(2).value);
		myLinkedList.printList();
//		System.out.println("The index element : "+myLinkedList.get(2).value);
	}

}
