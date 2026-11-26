import static java.lang.Math.max;
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+2];

        int longest = 0;
        for(int i = nums1.length-1; i >= 0; i--){
            for(int j = nums2.length-1; j >= 0; j--){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                    longest = max(longest, dp[i][j]);
                }

            }
        }
        return longest;
        
    }
}