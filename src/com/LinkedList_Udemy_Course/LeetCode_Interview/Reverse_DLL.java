package com.LinkedList_Udemy_Course.LeetCode_Interview;

public class Reverse_DLL {


    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public Reverse_DLL(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }
    
    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }
    // Method to reverse the linked list
    public void reverse() {
        Node current = head;
        Node temp = null;
     
        while (current != null) {
            // swap the prev and next pointers of the current node
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
     
            // move to the next node
            current = current.prev;
        }
     
        // swap the head and tail pointers
        temp = head;
        head = tail;
        tail = temp;
    }
	// WRITE REVERSE METHOD HERE //
	//                           //
	//                           //
	//                           //
	//                           //
	///////////////////////////////
    public static void main(String[] args) {

    	Reverse_DLL myDLL = new Reverse_DLL(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);
        
        System.out.println("DLL before reverse:");
        myDLL.printList();
        
        myDLL.reverse();
        
        System.out.println("\nDLL after reverse:");
        myDLL.printList();
        
        
        /*
       		EXPECTED OUTPUT:
        	----------------
            DLL before reverse:
            1
            2
            3
            4
            5
            
            DLL after reverse:
            5
            4
            3
            2
            1
        
     	*/

    }	
}
