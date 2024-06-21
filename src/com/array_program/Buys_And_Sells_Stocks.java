package com.array_program;

public class Buys_And_Sells_Stocks {
	public static int buysAndSellsStocks(int prices[])
	{
		int buyPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i = 0; i<prices.length;i++)
		{
			if(buyPrice < prices[i])  // profit
			{
				int profit = prices[i] - buyPrice;  //todays profit
				maxProfit = Math.max(maxProfit, profit);
			}
			else
			{
				buyPrice = prices[i];
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		int prices[] = {7, 1, 5 ,3 ,6, 4};
		
		System.out.println(buysAndSellsStocks(prices));
	}

}
