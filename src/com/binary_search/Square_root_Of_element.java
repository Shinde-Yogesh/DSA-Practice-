package com.binary_search;

public class Square_root_Of_element {

 public static long binarySearch(int n)
 {
	 long s=0;
	 long e = n;
	 long mid = s +(e-s)/2;
	 
	 long  ans = -1;
	 
	 while(s<e)
	 {
	long   square = mid * mid;
		 
		 if(square == n)
		 {
			 return mid;
		 }
		 
		 if(square < n)
		 {
			 ans = mid;
			 s = mid+1;
		 }
		 else
		 {
			 e = mid-1;
		 }
		 mid = s +(e-s)/2;
	 }
	return ans;
	 
 }
 public static long mysquare(int x)
 {
	return binarySearch(x); 
 }
 public static void main(String[] args) {
	System.out.println(mysquare(1000000));
}
}
