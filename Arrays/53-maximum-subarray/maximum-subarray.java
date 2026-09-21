class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;

        int msum = nums[0], csum = nums[0];
        
        
        for(int i = 1; i < nums.length; i++){
            csum = Math.max(csum, 0);
            csum += nums[i];
            
            msum = Math.max(csum, msum);
        }

        return msum;
    }    
}