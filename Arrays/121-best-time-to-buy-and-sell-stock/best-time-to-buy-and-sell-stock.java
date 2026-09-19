class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = prices.length-2;
        int j = prices.length-1;
        while(i >= 0 && j >= 0){
            if(prices[i] > prices[j]){
                j = i;
                i--;
                continue;
            }
            profit = Math.max(prices[j] - prices[i], profit);
            i--;
        }
        return profit;

        
    }

}