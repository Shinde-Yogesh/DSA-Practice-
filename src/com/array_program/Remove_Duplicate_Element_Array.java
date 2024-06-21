package com.array_program;

import java.util.HashSet;
import java.util.Arrays;

public class Remove_Duplicate_Element_Array {

    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        System.out.println("Unique elements: " + set);
        return set.size();
    }

    public int removeDuplicatesValue(int[] nums) {
        if (nums.length == 0)
            return 0;

        int addIndex = 1; // Index at which unique elements will be inserted

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) { // If true, nums[i + 1] is a new unique number
                nums[addIndex] = nums[i + 1];
                addIndex++;
            }
        }
        return addIndex;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 2,3,4,4,5};

        // Calling static method
        System.out.println("Number of unique elements (HashSet method): " + removeDuplicates(nums));

        // Sorting the array to use with the in-place duplicate removal method
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        // Creating an instance to call the instance method
        Remove_Duplicate_Element_Array instance = new Remove_Duplicate_Element_Array();
        int newLength = instance.removeDuplicatesValue(nums);

        System.out.print("Array after removing duplicates (in-place method): ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
