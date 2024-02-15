package com.stack_program;

public class Two_Stack_Push {
	int[] array;
	int top1;
	int top2;
	int size;

	Two_Stack_Push(int size) {
		this.size = size;
		array = new int[size];
		top1 = -1;
		top2 =size;
	}
	
	// for push method 1
	void push1(int num)
	{
		if(top2- top1 > 1)
		{
			top1 ++;
			array[top1] = num;
		}else
		{
			//stack overflow
			System.out.println("Stack is Overflow ");
			
		}
	}
	
	void push2(int num)
	{
		if(top2- top1 > 1)
		{
			top2 --;
			array[top2] = num;
		}else
		{
			//stack overflow
			System.out.println("Stack is Overflow ");
			
		}
	}
//	int pop()
//	{
//		if(top1 >= 0)
//		{
//			
//		}
//	}
}
