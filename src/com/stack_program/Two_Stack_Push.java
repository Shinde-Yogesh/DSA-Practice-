package com.stack_program;

public class Two_Stack_Push {

	int[] array;
	int top1;
	int top2;
	int size;

	Two_Stack_Push() {
		size = 100; // GFG need to initialize the value in hard core
		array = new int[size];
		top1 = -1;
		top2 = size;
	}

//Function to push an integer into the stack1.
	void push1(int x) {
		top1++;
		array[top1] = x;

	}

//Function to push an integer into the stack2.
	void push2(int x) {
		top2--;
		array[top2] = x;
	}

//Function to remove an element from top of the stack1.
	int pop1() {
		if (top1 == -1) {
			return -1;
		} else {
			return array[top1--]; // decrease the pointer to get value
		}

	}

//Function to remove an element from top of the stack2.
	int pop2() {
		if (top2 == size) {
			return -1;
		} else {
			return array[top2++]; // if pointer reach to the length means array empty
		}
	}

	// int pop() // { // if(top1 >= 0) // { // // } // }

	public static void main(String[] args) {
		Two_Stack_Push obj = new Two_Stack_Push();
		obj.push1(1);
		obj.push2(2);
		System.out.println(obj.pop1());
		obj.push1(3);
		System.out.println(obj.pop1());
		System.out.println(obj.pop1());
		System.out.println(obj.pop2());
		System.out.println(obj.pop2());

	}
}

// int[] array = new int[3]; }

//ArrayList<Integer> al;
//
//Two_Stack_Push() {
//	al = new ArrayList<>();
//	al.add(-1);
//}
//
////Function to push an integer into the stack1.
//void push1(int x) {
//	al.add(0, x);
//}
//
////Function to push an integer into the stack2.
//void push2(int x) {
//	al.add(x);
//}
//
////Function to remove an element from top of the stack1.
//int pop1() {
//	if (al.get(0) != -1)
//		return al.remove(0);
//
//	else
//		return -1;
//}
//
////Function to remove an element from top of the stack2.
//int pop2() {
//	if (al.get(al.size() - 1) != -1)
//		return al.remove(al.size() - 1);
//	else
//		return -1;
//}
//
//public void print() {
//
//	System.out.println(al);
//
//}
//
//public static void main(String[] args) {
//	Two_Stack_Push obj = new Two_Stack_Push();
//	obj.push1(2);
//	obj.push1(3);
//	obj.push2(4);
//	obj.print();