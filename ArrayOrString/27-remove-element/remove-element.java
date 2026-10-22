class Solution {
    public int removeElement(int[] nums, int val) {
        int c = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == val) c++;
        }
        int res = nums.length - c;
        
        int[] duplicate = Arrays.copyOf(nums, nums.length);
        int j = 0;

        for(int i = 0; i < res; i++, j++){
            while(nums[j] == val){j++;}

            nums[i] = nums[j];
        
        }
        return res;
    }
}