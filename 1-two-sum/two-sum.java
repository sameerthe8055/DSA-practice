class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int indexN1 = -1, indexN2 = -1;
        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            
            if(hm.get(need) != null){
                indexN1 = i;
                indexN2 = hm.get(need);
                break;
            }
            else{
                hm.put(nums[i], i);
            }
        }
        return new int[]{indexN1, indexN2};        
    }
}