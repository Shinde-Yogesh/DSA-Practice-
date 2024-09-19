package com.LinkedList;

import java.util.ArrayList;

public class Palindrom_in_LL {

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

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // Approach 1: Using an ArrayList to check for palindrome
    public static boolean isPalindrome(Node head) {
        ArrayList<Node> nodeList = new ArrayList<>();
        Node temp = head;
        
        // Add nodes to ArrayList
        while (temp != null) {
            nodeList.add(temp);
            temp = temp.next;
        }
        
        return checkPalindrome(nodeList);
    }

    private static boolean checkPalindrome(ArrayList<Node> nodeList) {
        int start = 0;
        int end = nodeList.size() - 1;

        // Check for palindrome by comparing nodes from both ends
        while (start <= end) {
            if (nodeList.get(start).data != nodeList.get(end).data) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Approach 2: Optimized - Using middle node and reversing the second half
    public static boolean isPalindromeApproach2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Get the middle node
        Node middle = getMiddleNode(head);
        Node temp = middle.next;
        middle.next = reverseList(temp);

        // Compare both halves
        Node leftPointer = head;
        Node rightPointer = middle.next;

        while (rightPointer != null) {
            if (leftPointer.data != rightPointer.data) {
                return false;
            }
            leftPointer = leftPointer.next;
            rightPointer = rightPointer.next;
        }

        // Restore the original list (optional)
        temp = middle.next;
        middle.next = reverseList(temp);
        return true;
    }

    private static Node getMiddleNode(Node head) {
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static Node reverseList(Node head) {
        Node current = head;
        Node previous = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    // Approach 3: Convert to string and check palindrome
    static String convertToString(Node head) {
        StringBuilder s = new StringBuilder();
        Node current = head;

        while (current != null) {
            s.append(Integer.toString(current.data));
            current = current.next;
        }
        return s.toString();
    }

    static boolean isPalindromeStringApproach(Node head) {
        if (head == null || head.next == null)
            return true;  // Single node is a palindrome

        String original = convertToString(head);

        // Reverse the linked list
        Node prev = null, curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Convert reversed list to string
        String reversed = convertToString(prev);

        return original.equals(reversed);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(1);

        node1.next = node2;
        node2.next = node3;

        Node head = node1;

        // Print the list
        System.out.println("Original Linked List:");
        printList(head);

        // Test Approach 1
        System.out.println("Is Palindrome (ArrayList Approach): " + isPalindrome(head));

        // Test Approach 2
        System.out.println("Is Palindrome (Optimized Approach): " + isPalindromeApproach2(head));

        // Test Approach 3
        System.out.println("Is Palindrome (String Approach): " + isPalindromeStringApproach(head));
    }
}
