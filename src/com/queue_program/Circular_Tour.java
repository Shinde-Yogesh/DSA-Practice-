package com.queue_program;

public class Circular_Tour {
	public static int  tour(int petrol[], int distance[])
    {
		
		// for the remaining the (petrol - distance) upto certain place give -1 then for storing the extra time to again compare
		int deficit = 0;
		
		//the output (Basic Condition)
		int balance = 0;
		
		//Pointing the curr node to return exact location
		int start = 0;
		
		for(int i = 0; i< petrol.length; i++)
		{
			//balance check
			balance += petrol[i] - distance[i];
			if(balance < 0)
			{
				deficit += balance;
				
				//replace the start with (i+1) means (front = rear+1)
				start = i + 1;
				
				//Initialize the balance 0
				balance = 0;
			}
		}
		//saving the time for next call because the prev (-) and current (output value) greater than 0 means reach at the start(Condition done)
		if(deficit + balance >=0)
		{
			return start;
		}
		else
		{
			return -1;
		}
    }
	public static void main(String[] args) {
		int Petrol[]  = {4, 6, 7 ,4};
		int Distance[] = {6, 5, 3, 5};
		System.out.println(tour(Petrol,Distance));
	}
}
