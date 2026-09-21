class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0) return;
        rev(nums, 0, nums.length-1);
        rev(nums, 0, k % nums.length -1);
        rev(nums, k % nums.length, nums.length-1);
        
    }
    void rev(int[] arr,int i,int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
    }
}
