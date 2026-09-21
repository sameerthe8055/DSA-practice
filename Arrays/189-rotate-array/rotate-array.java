class Solution {
    public void rotate(int[] arr, int k) {
        if(arr.length == 0) return;
        int i, j;
        //rev(nums, 0, nums.length-1);
        {
            i = 0;
            j = arr.length-1;
            while(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // rev(nums, 0, k % nums.length -1);
        {
            i = 0;
            j = k % arr.length -1;
            while(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        // rev(nums, k % nums.length, nums.length-1);
        {
            i = k % arr.length;
            j = arr.length -1;
            while(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        
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
