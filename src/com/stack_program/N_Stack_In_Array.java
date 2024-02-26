package com.stack_program;

public class N_Stack_In_Array {
	int array[];
	int top[];
	int next[];
	
	int n,s;
	int freespot;
	public N_Stack_In_Array(int N,int S)
	{
		n=N;
		s = S;
		array = new int[s];
		top = new int[n];
		next= new int[s];
		
		//top initialize 
		for(int i = 0; i<n;i++)
		{
			top[i] = -1;
		}
		
		//initialize the next 
		for(int i = 0; i<s;i++)
		{
			next[i] = i+1;
		}
//		update the last index with -1
		next[s-1] = -1;
		
		//initialize freespot
		freespot = 0;
	}
	

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
      //check the overflow condintion
    	if(freespot== -1)
    	{
    		return false;
    	}
    	//find the index
    	int index= freespot;
    	
    	//update the freespot
    	freespot = next[index];
    	
    	//insert the element to the array
    	array[index] = x;
    	
    	//update the next
    	next[index] = top[m-1];
    	
    	//update top
    	top[m-1] = index;
    	
    	
    	return true;
    	
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        
    	//check for the underflow condition
    	if(top[m-1] == -1)
    	{
    		return -1;
    	}
    	
    	
    	//store the top elemetnt into the index
    	int index = top[m-1];
    	
    	//update the top 
    	top[m-1] = next[index];
    	
    	
    	//freespot store to the next array of index
    	next[index] = freespot;
    	
    	
    	//index value store in the freespot
    	freespot = index;
    	
    	return array[index];
    }
    public static void main(String[] args) {
		int n = 3;
		int s = 6;
		int q = 5;
		
		N_Stack_In_Array obj = new N_Stack_In_Array(n, s);
		System.out.println(obj.push(10, 1));
		System.out.println(obj.push(20, 1));
		System.out.println(obj.push(30, 2));
		
		System.out.println(obj.pop(1));
		System.out.println(obj.pop(2));
	}
}
