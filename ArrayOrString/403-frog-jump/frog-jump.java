import java.util.*;
class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        boolean[][] dp = new boolean[stones.length][stones.length];
        
        dp[1][0] = true;
        for(int i=1; i<stones.length; i++){
            int stone = stones[i];
            for(int j = 0; j < stones.length; j++){
                // find last stone from dp[i][n] = true;
                if( i != j && dp[i][j] == true){
                    int lastStone = stones[j];
                    int jump = stone - lastStone;

                    // true next possible jumps from here{}
                    for(int k = i+1; k < stones.length ; k++){
                        int thisStone = stones[k];
                        if(thisStone == stone+jump) dp[k][i] = true;
                        else if(thisStone == stone+jump-1) dp[k][i] = true;
                        else if(thisStone == stone+jump+1) dp[k][i] = true;
                    }
                }
            }        

        }
        for(boolean res: dp[stones.length-1]){
            if(res) return true;
        }
        return false;

        // if(stones[1] != 1) return false;
        // HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();

        // for(int stone: stones){
        //     dp.put(stone, new HashSet<>());
        // }

        // dp.get(0).add(0);
        // for(int stone: stones){
        //     for(int jump: dp.get(stone)){
        //         for(int step=-1; step<2; step++){
        //             int nextStone = stone+jump+step;
        //             if(stone != nextStone && dp.containsKey(nextStone)){
        //                 dp.get(nextStone).add(jump+step) ;
        //             }
        //         }
        //     }
        // }
        // if(!dp.get(stones[stones.length-1]).isEmpty()) return true;
        // return false;
        
    }
}