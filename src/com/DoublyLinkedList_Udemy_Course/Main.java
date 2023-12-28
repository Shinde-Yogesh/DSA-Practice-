package com.DoublyLinkedList_Udemy_Course;

public class Main {
	public static void main(String[] args) {
		DoublyLinkedList myDLL = new DoublyLinkedList(7);
//		myDLL.getHead();
		
		myDLL.append(8);
		myDLL.append(9);
		myDLL.append(10);
//		myDLL.getTail();
//		myDLL.printList();
//		myDLL.removeLast();
//		myDLL.printList();
		myDLL.prepend(6);
		System.out.println(myDLL.get(2).value);
		System.out.println(myDLL.get(4).value);
//		myDLL.removeFirst();
		myDLL.printList();
	}
}
