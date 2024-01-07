package com.LinkedList_Udemy_Course.LeetCode_Interview;

public class Reverse_Between {
	private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Reverse_Between(int value) {
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
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
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

    // WRITE THE REVERSEBETWEEN METHOD HERE //
    //                                      //
    //                                      //
    //                                      //
    //                                      //
    //////////////////////////////////////////
      public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;
    
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
    
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }
    
        Node currentNode = previousNode.next;
    
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }
    
        head = dummyNode.next;
    }
      public static void main(String[] args) {
          
          // Create a linked list with values 1, 2, 3, 4, and 5
    	  Reverse_Between myLinkedList = new Reverse_Between(1);
          myLinkedList.append(2);
          myLinkedList.append(3);
          myLinkedList.append(4);
          myLinkedList.append(5);

          System.out.println("Original linked list: ");
          myLinkedList.printList();

          // Reverse a sublist within the linked list
          myLinkedList.reverseBetween(1, 3);
          System.out.println("\nReversed sublist (1, 3): ");
          myLinkedList.printList();

          // Reverse another sublist within the linked list
          myLinkedList.reverseBetween(0, 4);
          System.out.println("\nReversed entire linked list: ");
          myLinkedList.printList();

          // Reverse a sublist of length 1 within the linked list
          myLinkedList.reverseBetween(2, 2);
          System.out.println("\nReversed sublist of length 1 (2, 2): ");
          myLinkedList.printList();

          // Reverse an empty linked list
          	Reverse_Between emptyList = new Reverse_Between(0);
          emptyList.makeEmpty();
          emptyList.reverseBetween(0, 0);
          System.out.println("\nReversed empty linked list: ");
          emptyList.printList();
          
          /*
              EXPECTED OUTPUT:
              ----------------
              Original linked list: 
              1
              2
              3
              4
              5
              
              Reversed sublist (1, 3): 
              1
              4
              3
              2
              5
              
              Reversed entire linked list: 
              5
              2
              3
              4
              1
              
              Reversed sublist of length 1 (2, 2): 
              5
              2
              3
              4
              1
              
              Reversed empty linked list: 
          
          */

      }


}

/*
Solution

Are you finding this coding exercise a bit challenging?

You're not alone—many students feel the same way. If you need some help understanding the code, just check out the "Hints" tab.

I've added some extra explanations there to guide you through it. Happy coding! 🌟





    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;
    
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
    
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }
    
        Node currentNode = previousNode.next;
    
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }
    
        head = dummyNode.next;
    }




Given the list:
1 → 2 → 3 → 4 → 5.


With 0-based indexing, our goal is: Reverse nodes between indices 1 and 3 (inclusive) to achieve the result:
1 → 4 → 3 → 2 → 5.



Detailed Walkthrough:



Preliminary Steps:

Check if the list is empty:

if (head == null) return;
We return right away if there's nothing in the list to reverse.



Create a dummy node:

Node dummyNode = new Node(0);
dummyNode.next = head;
The dummy node is a helper to simplify our code, especially if we have to reverse starting from the very first node.



Preparation:

Move to the node right before the start of the reversal:

Node previousNode = dummyNode;
for (int i = 0; i < startIndex; i++) {
    previousNode = previousNode.next;
}
In this case, for reversal starting at index 1, prev will now point to node 1 (at index 0).



Position current at the beginning of the reversal section:

Node currentNode = previousNode.next;
So, currentNode now points to node 2, marking the start of our reversal.



The Core Loop:

Perform the node reversal between m and n:

for (int i = 0; i < endIndex - startIndex; i++) {
    Node nodeToMove = currentNode.next;
    currentNode.next = nodeToMove.next;
    nodeToMove.next = previousNode.next;
    previousNode.next = nodeToMove;
}


Using our example, where we reverse nodes from indices 1 through 3:

First iteration (Reversing node at index 2, i.e., node 3):

nodeToMove = currentNode.next: Now, nodeToMove points to node 3.

currentNode.next = nodeToMove.next: Node 2 (our currentNode) now directs to node 4, leaving out node 3. Intermediate State: 1 → 2 → 4 → 5. Node 3 (nodeToMove) stands alone.

nodeToMove.next = previousNode.next: Node 3 (nodeToMove) links to node 2.

previousNode.next = nodeToMove: Node 1 (previousNode) connects to node 3. Result:
1 → 3 → 2 → 4 → 5.

Second iteration (Reversing node at index 3, i.e., node 4):

nodeToMove = currentNode.next: nodeToMove now points at node 4.

currentNode.next = nodeToMove.next: Node 2 now shifts to node 5, skipping node 4. Intermediate State: 1 → 3 → 2 → 5. Node 4 (nodeToMove) is free.

nodeToMove.next = previousNode.next: Node 4 (nodeToMove) links to node 3.

previousNode.next = nodeToMove: Node 1 (previousNode) connects to node 4. Result:
1 → 4 → 3 → 2 → 5.
Our target reversed order!



Finalization:

Realign the list head:

head = dummyNode.next;
If the original first node was part of our reversal, this ensures the head now rightly points to the list's beginning.



If you are having a hard time grasping this, I recommend illustrating with diagrams or using physical blocks and arrows which can oftentimes make it clearer.

Also, it might help to check the "Code with inline comments" below:





Code with inline comments:



public void reverseBetween(int startIndex, int endIndex) {
    // Check: If linked list is empty, nothing to reverse.
    // Exit the method.
    if (head == null) return;
 
    // Create a 'dummyNode' that precedes the head.
    // Simplifies handling edge cases.
    Node dummyNode = new Node(0);
    dummyNode.next = head;
 
    // 'previousNode' is used to navigate to the node 
    // right before our sublist begins.
    Node previousNode = dummyNode;
 
    // Move 'previousNode' to node just before sublist.
    for (int i = 0; i < startIndex; i++) {
        previousNode = previousNode.next;
    }
 
    // 'currentNode' marks the first node of sublist.
    Node currentNode = previousNode.next;
 
    // Loop reverses the section from startIndex to endIndex.
    for (int i = 0; i < endIndex - startIndex; i++) {
 
        // 'nodeToMove' is the node we'll move to sublist start.
        Node nodeToMove = currentNode.next;
 
        // Detach 'nodeToMove' from its current position.
        currentNode.next = nodeToMove.next;
 
        // Attach 'nodeToMove' at the beginning of the sublist.
        nodeToMove.next = previousNode.next;
        
        // Move 'nodeToMove' to the start of our sublist.
        previousNode.next = nodeToMove;
    }
 
    // Adjust 'head' if the first node was part of sublist.
    head = dummyNode.next;
}*/