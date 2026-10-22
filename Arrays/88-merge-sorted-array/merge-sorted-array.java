class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // move all nums of array1 to end
        for(int i = m-1,j = nums1.length-1; i != -1; i--,j-- ){
            nums1[j] = nums1[i];
        }

        int p1 = nums1.length-m;
        int p2 = 0;
        int i;

        // start merging array 1 and array2
        for(i= 0;
            i < nums1.length && p1 < nums1.length && p2 < n;
            i++ 
            ){
            if(nums1[p1] < nums2[p2]){
                nums1[i] = nums1[p1++];
                continue;
            }
            nums1[i] = nums2[p2++];
        }

        while(i < nums1.length && p2 < n){
            nums1[i] = nums2[p2++];
            i++;
        }             
    }
}