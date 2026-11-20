import static java.lang.Math.max;
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0 ) return 0;
        if(n == 1) return nums[0];
        int temp = nums[0];
        nums[0] = 0;
        int firstrob = robber(nums);
        nums[0] = temp;
        nums[n-1] = 0;
        return max(firstrob, robber(nums));
        
        
    }
    public int robber(int[] nums){
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = max(nums[1], nums[0]);
        for(int i = 2; i < n; i++){
            int rob = nums[i] + dp[i-2];
            int skip = dp[i-1];

            dp[i] = max(rob, skip);
        }
        return dp[n-1];
    }
}