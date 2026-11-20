/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import static java.lang.Math.max;
class Solution {
    public int rob(TreeNode root) {
        int[] res = solve(root);
        return max(res[0], res[1]);
        
        
    }
    int[] solve(TreeNode root){
        if(root == null) return new int[]{0, 0}; // rob, skip
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        // rob = curr val + (i+2)val
        int rob = (
            root.val +
            left[1] +
            right[1]
        );
        // skip = (i+1) val
        int skip = max(left[0], left[1]) +
            max(right[0], right[1]);

        return new int[] {rob, skip}; 

    }
}