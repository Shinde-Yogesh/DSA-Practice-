package com.DoublyLinkedList_Udemy_Course;

public class Main {
	public static void main(String[] args) {
		DoublyLinkedList myDLL = new DoublyLinkedList(7);
		myDLL.getHead();
		
		myDLL.append(8);
		myDLL.append(9);
		myDLL.append(10);
		myDLL.getTail();
//		myDLL.printList();
//		myDLL.removeLast();
		myDLL.printList();
		myDLL.prepend(6);
		myDLL.printList();
		myDLL.removeFirst();
		myDLL.printList();
	}
}
