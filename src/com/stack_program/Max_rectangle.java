package com.stack_program;

import java.util.Stack;

public class Max_rectangle {
	  public static int maxArea(int M[][], int n, int m) {
	        
	        int ans = 0;
			try {
				ans = maxRect(M[0], m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	        for(int i=1; i<n; i++){
	            for(int j=0; j<m; j++){
	                if(M[i][j]==0) continue;
	                M[i][j] = M[i-1][j]+1;
	                //System.out.print(M[i][j] +" ");
	            }
	            ans = Math.max(ans, maxRect(M[i], m));
	            //System.out.println("");
	        }
	        return ans;
	    }
	    
	    public static int maxRect(int a[], int n){
	        
	        Stack<Integer> st = new Stack<Integer>();
	        int left[] = new int[n];
	        int right[] = new int[n];
	        
	        for(int i=0; i<n; i++){
	            
	            while(!st.isEmpty() && a[st.peek()]>=a[i]) st.pop();
	            
	            left[i] = st.isEmpty() ? -1 : st.peek();
	            st.push(i);
	        }
	        st.clear();
	        
	        for(int i=n-1; i>=0; i--){
	            
	            while(!st.isEmpty() && a[st.peek()]>=a[i]) st.pop();
	            
	            right[i] = st.isEmpty() ? n : st.peek();
	            st.push(i);
	        }
	        
	        int maxi = Integer.MIN_VALUE;
	        
	        for(int i=0; i<n; i++){
	            maxi = Math.max(maxi, a[i]*(right[i]-left[i]-1));
	        }
	        return maxi;
	    }
	public static void main(String[] args) {
		int[][] array = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, };
		
		System.out.println(maxArea(array,4,4));
	}
}
