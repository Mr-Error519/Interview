package niuke.dp.bm81;

public class Solution {
    public int maxProfit (int[] prices) {
        // write code here
        int buy = 0;
        int sell = 0;
        int profit = 0;
        while(sell<prices.length){
            int pre = buy;
            sell = buy+1;
            while(sell<prices.length&&prices[sell]>prices[pre]){
                ++sell;
                ++pre;
            }

            if(sell<prices.length){
                profit+=prices[sell]-prices[buy];
                buy = sell;
            }else{
                break;
            }


        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{8,9,2,5,4,7,1};
        Solution solution = new Solution();
        solution.maxProfit(prices);

    }
}
