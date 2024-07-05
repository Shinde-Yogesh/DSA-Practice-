/*
package com.recursion_program;

import java.util.ArrayList;
import java.util.List;

public class Permutaion_of_Array_Number {
	public static List<List<Integer>> permute(int[] nums) {
		// Initializing one data structure which store the value during recursive call
		// in it
		List<Integer> ds = new ArrayList<>();

		// Initializing array of array which print output the permutation of array
		List<List<Integer>> ans = new ArrayList<>();

		// Initializing another array of length final array nums of type boolean which
		// mark the value true when we visited that particular index during recursive
		// call because we don't want duplicate value in array (* not considering
		// duplicate value which already present in initial array)
		boolean[] freq = new boolean[nums.length];
		// calling the function
		permutation(ds, ans, nums, freq);
		return ans;

	}

	public static void permutation(List<Integer> ds, List<List<Integer>> ans, int[] nums, boolean[] freq) {

		// this is base condition whe size of declared data structure became equal to
		// initial array then that time ds contain one cycle of permutation and we add
		// it to ans.
		if (ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		// running loop till n and marking visited not visited during recursive call
		for (int i = 0; i < nums.length; i++) {
			if (!freq[i]) {
				// if not visited then mark true
				freq[i] = true;
				// add it to ds
				ds.add(nums[i]);
				// call the function again because it recursion calling back to back
				permutation(ds, ans, nums, freq);
				// when recursing reaches equal to size of intial array then remove tha last
				// element of ds and unmarked the visited array
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 2 };
		System.out.println(permute(nums));

	}
}

*/

package com.recursion_program;

import java.util.ArrayList;
import java.util.List;

public class Permutaion_of_Array_Number {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permutation(ds, ans, nums, freq);
        return ans;
    }

    public static void permutation(List<Integer> ds, List<List<Integer>> ans, int[] nums, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                permutation(ds, ans, nums, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int nums1[] = {};
        System.out.println(permute(nums1)); // Expected output: [[]]

        int nums2[] = {1};
        System.out.println(permute(nums2)); // Expected output: [[1]]

        int nums3[] = {1, 2, 3};
        System.out.println(permute(nums3)); // Expected output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        int nums4[] = {1, 2, 2};
        System.out.println(permute(nums4)); // Expected output: Unique permutations of [1, 2, 2]
    }
}
