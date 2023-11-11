package com.array_program;

import java.util.Arrays;

public class Count_Prime_Number {
	   public static int countPrimes(int n) {
	        if(n<2) return 0;
	        boolean[] primes = new boolean[n];
	         Arrays.fill(primes, true);
	         
	        int count=0;
	        for (int p = 2;p < n; p++) {
	            if(primes[p])
	            {
	                count++;
	                 if((long)p*p<n)
	                {
	                     for(int i=p*p;i<n;i+=p)
	                     primes[i]=false;
	                }

	            }
	          }
	    return count;
	    }
	   public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}
}


/*      

								Approach
This code implements a solution to count the number of prime numbers less than a given integer n using the Sieve of Eratosthenes algorithm.

The algorithm works as follows:

Initialize an array isPrime of boolean values to store whether each number from 0 to n is prime or not. Initially, all numbers are assumed to be prime.
Mark 0 and 1 as not prime, as they are not prime numbers (According to test cases).
Loop through the array from 2 to the square root of n.
For each number, if it is marked as prime, then mark all of its multiples as not prime by updating -
isPrime[j] = false where j = 2 * i, 3 * i, ..., n
Finally, loop through the isPrime array and count the number of prime numbers.
Time and Space Complexity
The time complexity of this algorithm is O(n * log(log(n))), as the loop only needs to run through the numbers up to the square root of n and marking the multiples of each prime number. The space complexity is O(n), as a boolean array of size n + 1 is used to store the prime numbers.

upvote.jpeg

Code
class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0 ;
        }
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime , true);  
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2 ; i*i<=n ; i++){
            for(int j = 2*i;j<=n;j+=i){
                isPrime[j] = false;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(isPrime[i]==true){
                count++;
            }
        }
        return count;
    }
}



*/