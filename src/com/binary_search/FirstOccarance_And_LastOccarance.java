package com.binary_search;

public class FirstOccarance_And_LastOccarance {
	public static int firstOccarance(int array[] , int size , int key)
	{
		int s = 0;
		int e = size-1;
		int mid = s + (e - s)/2;
		
		int ans = -1;
		while(s <= e)
		{
			if(array[mid] == key)
			{
				ans = mid;
				e = mid-1;

			}
			
			else if(key > array[mid])
			{
				s = mid + 1;
			}
			else if(key < array[mid])
			{
				e = mid - 1;
			}
			
			 mid = s + (e - s)/2;
		}
		
		return ans;
	}
	public static int lastOccarance(int array[] , int size , int key)
	{
		int s = 0;
		int e = size-1;
		int mid = s + (e - s)/2;
		
		int ans = -1;
		while(s <= e)
		{
			if(array[mid] == key)
			{
				ans = mid;
				s = mid+1;

			}
			
			else if(key > array[mid])
			{
				s = mid + 1;
			}
			else if(key < array[mid])
			{
				e = mid - 1;
			}
			
			 mid = s + (e - s)/2;
		}
		
		return ans;	}
	public static void main(String[] args) {
		int array[] = {1, 2,3,3,3,3,3,3,3,5};
		int key = 3;
		System.out.println("The key : "+key+" found in index "+firstOccarance(array, array.length, key));
		System.out.println("The key : "+key+" found in index "+lastOccarance(array, array.length, key));
	}

}
