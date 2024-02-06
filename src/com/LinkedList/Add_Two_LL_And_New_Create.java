package com.LinkedList;

public class Add_Two_LL_And_New_Create {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node addTwoLists(Node first, Node second) {
        // Reverse input linked lists
        first = reverse(first);
        second = reverse(second);

        Node res = null, cur = null;
        int carry = 0;

        // Traverse both lists
        while (first != null || second != null || carry > 0) {
            int sum = (first != null ? first.data : 0) + (second != null ? second.data : 0) + carry;
            carry = sum / 10;

            Node newNode = new Node(sum % 10);

            if (res == null) {
                res = cur = newNode;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }

            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        // Reverse the result before returning
        return reverse(res);
    }

    static Node reverse(Node head) {
        Node prev = null, current = head, next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void print(Node head) {
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
        System.out.println();
    }

    public static void main(String[] args) {
        Node NodeOne = new Node(1);
        Node NodeTwo = new Node(2);
        Node NodeThree = new Node(3);
        Node NodeFour = new Node(4);
        Node NodeFive = new Node(5);
        Node NodeSix = new Node(6);

        Node head = NodeOne;
        NodeOne.next = NodeTwo;
        NodeTwo.next = NodeThree;
        NodeThree.next = NodeFour;
        NodeFour.next = NodeFive;
        NodeFive.next = NodeSix;
        NodeSix.next = null;

        Node sampleOne = new Node(1);
        Node sampleTwo = new Node(2);
        Node sampleThree = new Node(3);
        Node sampleFour = new Node(4);

        Node sampleHead = sampleOne;
        sampleOne.next = sampleTwo;
        sampleTwo.next = sampleThree;
        sampleThree.next = sampleFour;
        sampleFour.next = null;

        print(head);
        print(sampleHead);

        Node result = addTwoLists(NodeOne, sampleOne);

        print(result);
    }
}
