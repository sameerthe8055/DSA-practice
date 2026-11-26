import static java.lang.Math.min;
import static java.lang.Math.max;
import java.util.*;

class Solution {
    public int cherryPickup(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        HashMap<List<Integer>, Integer> cache = new HashMap<>();


        class HelperClass{
            int dfs(int r,int c1,int c2){
                if(cache.containsKey(Arrays.asList(r, c1, c2))){
                    return cache.get(Arrays.asList(r, c1, c2));
                }
                else if(c1 == c2 || min(c1,c2) < 0 || max(c1, c2) == C){
                    return 0;
                }
                else if(r == R-1){
                    return grid[r][c1] + grid[r][c2];
                }
                int res = 0;
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        res = max(
                            res,
                            dfs(r+1, c1+i, c2+j)
                        );
                    }
                }
                res += grid[r][c1] + grid[r][c2];
                cache.put(Arrays.asList(r, c1, c2), res);
                return res;
            }
        }
        HelperClass helper = new HelperClass();
        return helper.dfs(0, 0, C-1);
        
    }
}