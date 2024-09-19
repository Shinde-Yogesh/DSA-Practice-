package com.LinkedList;

public class Merge_Sort_LL {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // printing the node
    public static void print(Node head) {

        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
        System.out.println();
    }

    static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge two sorted Linked Lists
    static Node merge(Node left, Node right) {
        // if either list is empty
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;  // fixed this to return 'left' instead of 'right'
        }

        // creating the dummy node
        Node ans = new Node(-1);
        Node temp = ans;

        while(left != null && right != null) {
            if(left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        while(left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }

        while(right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }
        
        return ans.next;
    }

    static Node mergeSort(Node head) {
        // base case
        if(head == null || head.next == null) {
            return head;
        }

        // break into 2 parts
        Node mid = findMid(head);

        Node left = head;
        Node right = mid.next;
        mid.next = null;

        // recursive sort
        left = mergeSort(left);
        right = mergeSort(right);

        // merge
        Node result = merge(left, right);
        return result;
    }

    public static void main(String[] args) {

        Node NodeOne = new Node(1);
        Node NodeTwo = new Node(3);
        Node NodeThree = new Node(2);
        Node NodeFour = new Node(5);
        Node NodeFive = new Node(1);
        Node NodeSix = new Node(1);

        Node head = NodeOne;

        NodeOne.next = NodeTwo;
        NodeTwo.next = NodeThree;
        NodeThree.next = NodeFour;
        NodeFour.next = NodeFive;
        NodeFive.next = NodeSix;
        NodeSix.next = null;

        System.out.println("The Linked List Before the Merge Sort Apply ");
        print(head);

        System.out.println("The Linked List After the Merge Sort Apply ");
        head = mergeSort(head);  // Corrected this line to update the head with the sorted list
        print(head);
    }
}
