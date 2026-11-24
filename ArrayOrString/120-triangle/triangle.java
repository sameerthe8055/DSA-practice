import static java.lang.Math.min;
class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int sum = 0;
        int m = t.size();
        for(int i = 1; i < m; i++){
            List<Integer> row  = t.get(i);
            List<Integer> lastRow = t.get(i-1);
            int n = row.size();

            for(int j = 0; j < n; j++){
                if(j == 0) row.set(0, row.get(0) + lastRow.get(0));
                else if(j == n-1){
                    row.set(j,
                        row.get(j) + lastRow.get(j-1)
                    );
                }
                else{
                    row.set(j, 
                        row.get(j) + 
                        min(lastRow.get(j-1), lastRow.get(j))
                    );
                }

            }

        }
        int mn = t.get(m-1).get(0);
        for(int num : t.get(m-1)){
            mn = min(mn, num); 
        }
        return mn;
            
        
    }
}