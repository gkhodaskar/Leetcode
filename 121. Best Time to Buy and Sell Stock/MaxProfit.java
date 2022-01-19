//Problem Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class MaxProfit {
    // Valley-Peak method : Only one transaction is allowed, so highest valley-peak difference is the answer
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int minPrice = Integer.MAX_VALUE;
//
//        for(int i = 0; i < prices.length; i++){
//            if(prices[i] < minPrice) // Valley
//                minPrice =  prices[i];
//            else if(prices[i] - minPrice > maxProfit) // Peak
//                maxProfit = prices[i] - minPrice;
//        }
//        return maxProfit;
//    }

    // Kadane's Algorithm, Maximum subarray sum
    public int maxProfit(int[] prices) {
        int maxSoFar = 0;
        int currMax = 0;

        for(int i = 1; i < prices.length; i++){
            currMax = Math.max(0, currMax += prices[i] - prices[i-1]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }

        return maxSoFar;
    }
}