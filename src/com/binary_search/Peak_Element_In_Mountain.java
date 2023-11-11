package com.binary_search;

public class Peak_Element_In_Mountain {
	public static int peakelemenet(int array[])
	{
		int s = 0;
		int e = array.length -1;
		
		int mid = s + (e-s)/2;
		
		while(s < e)
		{
			if(array[mid] < array[mid+1])
			{
				s = mid+1;
			}
			else
			{
				e=mid;
			}
			mid = s + (e-s)/2;
		}
		return s;
	}
	
	public static void main(String[] args) {
		int array[] = {0,10,5,2};
		
		System.out.println(peakelemenet(array));
	}

}
