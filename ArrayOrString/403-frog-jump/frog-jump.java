import java.util.*;
class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();

        for(int stone: stones){
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(0);
        for(int stone: stones){
            for(int jump: dp.get(stone)){
                for(int step=-1; step<2; step++){
                    int nextStone = stone+jump+step;
                    if(stone != nextStone && dp.containsKey(nextStone)){
                        dp.get(nextStone).add(jump+step) ;
                    }
                }
            }
        }
        if(!dp.get(stones[stones.length-1]).isEmpty()) return true;
        return false;
        
    }
}