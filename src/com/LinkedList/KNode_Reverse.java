package com.LinkedList;

public class KNode_Reverse {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public static Node reverseKNodes(Node head, int k) {
        Node current = head;
        Node previous = null;
        Node next = null;
        int count = 0;

        // Reverse the first K nodes of the linked list
        while (current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        // After reversing, next is now pointing to (k+1)th node
        // Recursively call for the list starting from the current.
        // And make the rest of the list as the next of the first node
        if (next != null) {
            head.next = reverseKNodes(next, k);
        }

        // previous is now the new head of the reversed group
        return previous;
    }

    public static void main(String[] args) {
        KNode_Reverse list = new KNode_Reverse();
        KNode_Reverse.head = new Node(85);
        KNode_Reverse.head.next = new Node(15);
        KNode_Reverse.head.next.next = new Node(4);
        KNode_Reverse.head.next.next.next = new Node(20);

        System.out.println("Given linked list:");
        list.printList(head);

        // Reverse every K nodes in the list
        // K means the reverse the node after the next node 
        int k = 2;
        head = KNode_Reverse.reverseKNodes(head, k);

        System.out.println("Reversed linked list in groups of K:");
        list.printList(head);
    }
}
