package com.recursion_program.easy_Level;

public class One_To_10_Number {
	
	//  static int i=1;
	  public static void number(int N)
	    {
	        //Your code here
	        if(1>N){
	            return;
	        }
	        number(N-1);
	        System.out.print(N+" ");
	        
	    }
	  public static void OneToN(int n)
	    {
		     if(n == 0)
	             return;
		     OneToN(n-1);
	       System.out.println(n);
	        
	    }
	public static void main(String[] args) {
		int n = 10;
		OneToN(n);
	}

}
