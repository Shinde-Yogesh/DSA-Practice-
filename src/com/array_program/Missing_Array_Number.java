package com.array_program;

public class Missing_Array_Number {
	public static int missingNumber(int array[], int n) {
        // Your Code Here
        
        int xor = 0;
        
        int anotherXor = 0;
        
        for(int i = 1; i <= n; i++)
        {
            anotherXor = anotherXor ^ i;
        }
        
        for(int i= 0; i<n-1; i++)
        {
            xor = xor ^ array[i];
        }
        return (xor ^ anotherXor);
    }
	
	public static void main(String[] args) {
		int array []= {6,1,2,8,3,4,7,10,5};
		int n = array.length;
		System.out.println(missingNumber(array, n));
	}

}
