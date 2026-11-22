import java.util.*;
import java.util.Arrays;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort( pairs,(a,b)-> 
            Integer.compare(b[1], a[1]) 
        );
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long score = 0;
        long maxScore = 0;
        long sum = 0;

        for(int[] pair: pairs){
            int num1 = pair[0];
            int num2 = pair[1];
            
            if(minHeap.size() < k-1){
                minHeap.offer(num1);
                sum += num1;
                continue;
            }
            minHeap.offer(num1);
            sum += num1;

            score = sum * num2;
            maxScore = Math.max(maxScore , score);

            sum -= minHeap.poll();
            
            
        }
        return maxScore;
    }
}