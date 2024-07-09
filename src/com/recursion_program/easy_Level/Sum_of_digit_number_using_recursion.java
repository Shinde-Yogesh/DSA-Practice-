package com.recursion_program.easy_Level;

public class Sum_of_digit_number_using_recursion {
	public static int sum_of_number(int num)
	{
		if(num == 0)
		{
			return 0;
		}
	
		return (num%10 +(sum_of_number(num/10)));
	}

	public static void main(String[] args) {
		int number = 12345;
		System.out.println(sum_of_number(number));
	}

}

/*int sum = 0;
while(num > 0)
{
	int rem = num %10;
	sum = rem+sum;
	num = num/10;
}
System.out.println(sum);*/
