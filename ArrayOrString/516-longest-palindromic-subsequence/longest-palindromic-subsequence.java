import static java.lang.Math.max;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int l = s.length();
        char[] s1 = s.toCharArray();
        char[] s2 = new char[l];
        for(int i = 0; i < l; i++){
            s2[l-1-i] = s1[i];
        }
        int[][] dp = new int[l+1][l+1];
        int longest = 1;

        for(int i = l-1; i >= 0; i--){
            for(int j = l-1; j >= 0; j-- ){
                if(s1[i] == s2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                    longest = max(longest, dp[i][j]);
                }
                else{
                    dp[i][j] = max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return longest;        
    }
}