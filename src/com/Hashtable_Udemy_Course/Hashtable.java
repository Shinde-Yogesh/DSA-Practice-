package com.Hashtable_Udemy_Course;

import java.util.ArrayList;
import java.util.List;

public class Hashtable<E> {
    private int size = 7;
    private List<Node>[] dataMap; // Use a List<Node> array

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public Hashtable() {
        dataMap = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            dataMap[i] = new ArrayList<>();
        }
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            List<Node> bucket = dataMap[i];
            for (Node temp : bucket) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % size;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        List<Node> bucket = dataMap[index];
        Node newNode = new Node(key, value);

        for (Node temp : bucket) {
            if (temp.key.equals(key)) {
                temp.value += value;
                return;
            }
        }

        bucket.add(newNode);
    }

    public int get(String key) {
        int index = hash(key);
        List<Node> bucket = dataMap[index];
        for (Node temp : bucket) {
            if (temp.key.equals(key))
                return temp.value;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (List<Node> bucket : dataMap) {
            for (Node temp : bucket) {
                allKeys.add(temp.key);
            }
        }
        return allKeys;
    }
}
