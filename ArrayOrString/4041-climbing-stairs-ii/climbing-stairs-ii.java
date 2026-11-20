import java.util.Arrays;
import static java.lang.Math.min;
import static java.lang.Math.pow;


class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int j = 1; j <= n; j++){
            for(int jump = 1; jump <= 3 && jump <= j; jump++){
                int i = j - jump;
                int total = costs[j-1] + ((int) pow(jump, 2)) + dp[i];

                dp[j] = min(dp[j], total);
            }
        }
        return dp[n];
        
    }
}