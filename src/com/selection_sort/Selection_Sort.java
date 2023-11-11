package com.selection_sort;

public class Selection_Sort {

	public static void selectionSort(int array[], int n)
	{
		
		for(int i = 0; i< n-1; i++)
		{
			int minIndex = i;
			for(int j = i+1; j<n; j++)
			{
				if(array[j] < array[minIndex])
				{
					minIndex = j;
				}
				
				int temp  = array[minIndex];
				array[minIndex]=array[j];
				array[j] = temp;
				
				
				
			} 
		}
		
		for(int i : array)
		{
			System.out.print(i +" ");
		}
	}

	
public static void main(String[] args) {
	int array[] = {29,72,98,13,87,66,52,21,36};
	selectionSort(array, array.length);
}
	
}
