import static java.lang.Math.max;
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if( n== 1) return nums[0];
        if(n == 2) return max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[n-1] = nums[n-1];
        dp[n-2] = max(nums[n-2], dp[n-1]);
        for(int i = n-3; i >= 0; i--){
            int rob = nums[i] + dp[i+2];
            int skip = dp[i+1];
            dp[i] = max(rob, skip);
        }
        return dp[0];
    }
} 