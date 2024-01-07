package com.LinkedList_Udemy_Course.LeetCode_Interview;

public class Binary_To_Decimal {
	private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Binary_To_Decimal(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }
    
    public void makeEmpty() {
        head = null;
        length = 0;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }
    
    //   +===================================================+
    //   |               WRITE YOUR CODE HERE                |
    //   | Description:                                      |
    //   | - This method converts a binary number,           |
    //   |   represented as a linked list, to a decimal int. |
    //   |                                                   |
    //   | Return type: int                                  |
    //   | - Returns the decimal equivalent of the binary    |
    //   |   number.                                         |
    //   |                                                   |
    //   | Tips:                                             |
    //   | - We use a while loop to traverse the linked list.|
    //   | - Multiply the current sum by 2 and add the value |
    //   |   at each node to get the decimal number.         |
    //   +===================================================+
    public int binaryToDecimal() {
        int num = 0;
        Node current = head;
        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }
public static void main(String[] args) {
        
        // ---------------
        // Convert 1011 to 11
        // ---------------
	Binary_To_Decimal list1 = new Binary_To_Decimal(1);
        list1.append(0);
        list1.append(1);
        list1.append(1);
        System.out.println("Convert 1011 to 11:");
        System.out.println("Input: 1 -> 0 -> 1 -> 1");
        System.out.println("Output: " + list1.binaryToDecimal());
        System.out.println("---------------");

        // ---------------
        // Convert 1100 to 12
        // ---------------
        Binary_To_Decimal list2 = new Binary_To_Decimal(1);
        list2.append(1);
        list2.append(0);
        list2.append(0);
        System.out.println("Convert 1100 to 12:");
        System.out.println("Input: 1 -> 1 -> 0 -> 0");
        System.out.println("Output: " + list2.binaryToDecimal());
        System.out.println("---------------");

        // ---------------
        // Convert 1 to 1
        // ---------------
        Binary_To_Decimal list3 = new Binary_To_Decimal(1);
        System.out.println("Convert 1 to 1:");
        System.out.println("Input: 1");
        System.out.println("Output: " + list3.binaryToDecimal());
        System.out.println("---------------");

        // ---------------
        // Convert empty list to 0
        // ---------------
        Binary_To_Decimal list4 = new Binary_To_Decimal(0);
        list4.makeEmpty();
        System.out.println("Convert empty list to 0:");
        System.out.println("Input: empty");
        System.out.println("Output: " + list4.binaryToDecimal());
        System.out.println("---------------");
    }

}
/*
     public int binaryToDecimal() {
        int num = 0;
        Node current = head;
        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }




The method aims to convert a binary number, represented by the linked list, into its decimal form. Here's a breakdown:



Step 1: Initialize Variables

int num = 0;
Node current = head;
num: This variable will hold the decimal equivalent of the binary number. It is initialized to zero.

current: This variable points to the head node of the linked list initially. We'll traverse through the list using this variable.



Step 2: Traverse Through the Linked List

while (current != null) {
    num = num * 2 + current.value;
    current = current.next;
}
The while loop runs as long as current is not null, meaning that we have not yet reached the end of the linked list.

Inside the loop:

num = num * 2 + current.value;: This statement performs the core logic for binary to decimal conversion. For each binary digit in the linked list, we multiply the current value of num by 2 (essentially performing a bit-shift to the left by one position), and add the value of the current node (current.value).

current = current.next;: This moves current to the next node in the list.



Step 3: Return the Result

return num;
Once the loop has traversed all nodes, the final decimal value is stored in num. This value is then returned.



Summary

The method iterates through the linked list from the head to the tail, treating each node's value as a digit in a binary number. It then performs the binary to decimal conversion, starting from the most significant bit (MSB) down to the least significant bit (LSB), and finally returns the decimal number.





Code with inline comments:



// Define the binaryToDecimal method for the LinkedList class
public int binaryToDecimal() {
    // Initialize an integer variable 'num' to 0.
    // This variable will hold the decimal value of the binary number.
    int num = 0;
 
    // Initialize a Node variable 'current' to point to the head of the LinkedList.
    // We will use 'current' to traverse through the LinkedList.
    Node current = head;
 
    // Begin a while loop that continues as long as 'current' is not null.
    // A null 'current' would mean we've reached the end of the LinkedList.
    while (current != null) {
 
        // For each node, shift the existing 'num' value one binary place to the left
        // by multiplying it by 2. Then, add the value of the current node to it.
        // This will build our binary number into its decimal equivalent,
        // one bit at a time.
        num = num * 2 + current.value;
 
        // Move to the next node in the LinkedList.
        // 'current.next' will either point to the next node, or to null
        // if we've reached the end of the list.
        current = current.next;
    }
 
    // After the loop, return the decimal value stored in 'num'.
    return num;
}




Explanation Using Decimal as an Analogy:

Constructing a Decimal Number: 123

Concept: Every position in a decimal number represents a power of 10, starting from the rightmost position as 100100 (which is 1) and increasing to the left.



Initialize:

Start with a result of 0.

Process the leftmost digit (1):

Multiply the current result by 10 (since we're in base 10): result = 0 * 10 = 0

Add the current digit: result = 0 + 1 = 1

Process the next digit (2):

Multiply the current result by 10: result = 1 * 10 = 10

Add the current digit: result = 10 + 2 = 12

Process the rightmost digit (3):

Multiply the current result by 10: result = 12 * 10 = 120

Add the current digit: result = 120 + 3 = 123

Conclusion:

At the end of this process, we've constructed the decimal number 123.



Now, let's construct a binary number using the same method. We'll use the binary number 110 as an example.



Constructing a Binary Number: 110

Concept: Every position in a binary number represents a power of 2, starting from the rightmost position as 2020 (which is 1) and increasing to the left.



Initialize:

Start with a result of 0.

Process the leftmost binary digit (1):

Multiply the current result by 2 (since we're in base 2): result = 0 * 2 = 0

Add the current binary digit: result = 0 + 1 = 1

Process the next binary digit (1):

Multiply the current result by 2: result = 1 * 2 = 2

Add the current binary digit: result = 2 + 1 = 3

Process the rightmost binary digit (0):

Multiply the current result by 2: result = 3 * 2 = 6

Add the current binary digit: result = 6 + 0 = 6

Conclusion:

At the end of this process, we've converted the binary number 110 into the decimal number 6.



Both of these step-by-step processes follow the general principle of constructing numbers in positional notation. The only difference between them is the base: base-10 for decimal and base-2 for binary.


     
     
     */
