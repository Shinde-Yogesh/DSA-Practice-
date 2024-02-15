package com.stack_program;

public class Stack {
	int[] array;
	int top;
	int size;
	
	Stack(int size)
	{
		this.size = size;
		array = new int[size];
		top = -1;
	}
	
	 void  push(int element)
	{
		//check for empty space
		if(size-top > 1)
		{
			top++;
			array[top] = element;
		}
		else
		{
			System.out.println("Stack is overflow");
		}
	}
	 void  pop()
	{
		 if(top >= 0)
		 {
			 top--;
		 }else
		 {
			 System.out.println("Stack is Underflow");
		 }
		
	}
	 int  peek()
	{
		if(top >= 0)
		{
			 return array[top];
		}
		else
		{
			System.out.println("Stack is Empty");
			return -1;
		}
		
	}
	
	boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//print the array
	public static void printArray(int array[])
	{
		for(int i = 0; i<array.length-1;i++)
		{
			System.out.print(array[i]+ " ");
		}
	}

	public static void main(String[] args) {
		Stack st = new Stack(5);
		st.push(22);
		st.push(44);
		st.push(66);
		st.push(88);
		st.push(100);
		System.out.println(st.peek());
		st.pop();
		System.out.println(st.peek());
	}
}
