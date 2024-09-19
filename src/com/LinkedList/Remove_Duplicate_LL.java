package com.LinkedList;

import java.util.HashSet;

public class Remove_Duplicate_LL {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Print the linked list
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
        System.out.println();
    }

    // Remove duplicates in a sorted linked list
    public static Node removeDuplicatesSorted(Node head) {
        if (head == null) {
            return null;
        }

        Node currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            if (currentNode.data == currentNode.next.data) {
                currentNode.next = currentNode.next.next;  // Skip duplicate
            } else {
                currentNode = currentNode.next;  // Move to next node
            }
        }

        return head;
    }

    // Remove duplicates in an unsorted linked list
    public static Node removeDuplicatesUnordered(Node head) {
        if (head == null) {
            return null;
        }

        HashSet<Integer> visitedData = new HashSet<>();
        Node currentNode = head;
        Node previousNode = null;

        while (currentNode != null) {
            if (!visitedData.contains(currentNode.data)) {
                visitedData.add(currentNode.data);
                previousNode = currentNode;
            } else {
                previousNode.next = currentNode.next;  // Skip duplicate node
            }
            currentNode = currentNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(5);
        Node node5 = new Node(1);
        Node node6 = new Node(1);

        Node head = node1;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        // Before applying the method
        System.out.println("Before removing duplicates:");
        printList(head);

        // Remove duplicates from unordered list
        removeDuplicatesUnordered(head);

        // After applying the method
        System.out.println("After removing duplicates:");
        printList(head);
    }
}
