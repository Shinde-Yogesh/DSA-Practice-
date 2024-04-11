package com.string_program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Overlap_Interval {
	 
	 public int[][] merge(int[][] intervals) {
	        // Sort intervals based on the start time
	        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
	        
	        List<int[]> merged = new ArrayList<>();
	        
	        // Initialize the first interval
	        int[] currentInterval = intervals[0];
	        merged.add(currentInterval);
	        
	        // Iterate through the intervals
	        for (int[] interval : intervals) {
	            int currentEnd = currentInterval[1];
	            int nextStart = interval[0];
	            int nextEnd = interval[1];
	            
	            // If the intervals overlap, merge them
	            if (nextStart <= currentEnd) {
	                // Update the end of the current interval
	                currentInterval[1] = Math.max(currentEnd, nextEnd);
	            } else {
	                // No overlap, add the new interval to the result list
	                currentInterval = interval;
	                merged.add(currentInterval);
	            }
	        }
	        
	        // Convert List<int[]> to int[][]
	        return merged.toArray(new int[merged.size()][]);
	    }
	    
	    public static void main(String[] args) {
	    	Merge_Overlap_Interval solution = new Merge_Overlap_Interval();
	        
	        // Example 1
	        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
	        int[][] result1 = solution.merge(intervals1);
	        System.out.println(Arrays.deepToString(result1));
	        
	        // Example 2
	        int[][] intervals2 = {{1,4},{4,5}};
	        int[][] result2 = solution.merge(intervals2);
	        System.out.println(Arrays.deepToString(result2));
	    }
}
