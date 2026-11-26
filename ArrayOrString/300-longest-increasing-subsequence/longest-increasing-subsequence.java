import java.util.HashSet;
import static java.lang.Math.max;

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] dp  = new int[nums.length];
        dp[nums.length-1] = 1;
        int longest = 1;
        for(int i = nums.length-2; i >= 0; i--){
            dp[i] = 1;
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] <  nums[j]){
                    dp[i] = max(dp[i], 1 + dp[j]);
                } 
            }
            longest = max(longest, dp[i]);
        }
        return longest;

    }
}