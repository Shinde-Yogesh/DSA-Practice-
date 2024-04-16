package com.array_program;

import java.util.HashSet;

public class Remove_Duplicate_Element_Array {
	 public static int removeDuplicates(int[] nums) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        for(int i : nums)
	        {
	            set.add(i);
	        }
	        System.out.println(set);
	        return set.size();
	    }
	 
	 
	 public int removeDuplicatesValue(int[] nums) {
         if(nums.length == 0)
	            return 0;
	        
	        int addIndex = 1; //index that unique characters will be inserted at

	        for(int i = 0; i < nums.length - 1; i++) {
	            
	            if(nums[i] < nums[i + 1]){ //if true, num[i + 1] is a new unique number
	              nums[addIndex] = nums[i + 1]; // 1 < 
	              addIndex++;
	            }
	        }
	        return addIndex;
    }
	 public static void main(String[] args) {
		 int nums[] = {1,1,2};
		 System.out.println(removeDuplicates(nums));
	}
}
