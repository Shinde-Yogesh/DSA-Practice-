package com.binary_search;

public class Search_Roted_Sorted_Array {
	public static int getPivot(int array[], int n)
	{
		int s = 0;
		int e  = n-1;
		int mid = s + (e-s)/2;
		
		while(s<e)
		{
			if(array[mid] >= array[0])
			{
				s = mid+1;
			}
			else {
				e = mid;
			}
			mid = s + (e-s)/2;
		}
		return s;
	}
	
	
	public static int binary_search(int array[], int s,int e, int key) {
		int start =s;
		int end = e;
		int mid = start + (end - start) / 2;

		while (start <= end) {
			if (array[mid] == key) {
				return mid;
			}

			// go towords right side

			if (key > array[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;;
		}
		return -1;
	}
	
	public static int  findPosition(int array[], int n, int k)
	{
		int pivot = getPivot(array, n);
		if(k >= array[pivot] && k <= array[n-1])
		{
			return binary_search(array, pivot,n-1, k);
		}
		else
		{
			return binary_search(array, 0,pivot-1, k);
		}
	}
	
	public static void main(String[] args) {
		int array[] = {1, 3, 5, 7, 8};
		System.out.println(findPosition(array, array.length, 3));
	}
}
