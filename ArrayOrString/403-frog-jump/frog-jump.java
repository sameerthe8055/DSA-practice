class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        boolean[][] dp = new boolean[stones.length][stones.length];

        dp[1][0] = true;
        for(int i = 0; i < stones.length-1; i++){
            int stone = stones[i];
            for(int j = 0; j < i; j++){
                if(dp[i][j] == true){
                    int lastStone = stones[j];
                    int jump = stone - lastStone;

                    int maxNextStone = stone + jump + 1;

                    for(int k = i+1; k < stones.length && stones[k] <= maxNextStone; k++ ){
                        if(stones[k] == maxNextStone){
                            dp[k][i] = true;
                        }
                        else if(stones[k] == maxNextStone-1){
                            dp[k][i] = true;
                        }
                        else if(stones[k] == maxNextStone-2){
                            dp[k][i] = true;
                        }
                    }


                }
            }
        } 
        for(boolean ans: dp[stones.length-1]){
            if(ans) return true;
        }  
        return false;      
    }
}