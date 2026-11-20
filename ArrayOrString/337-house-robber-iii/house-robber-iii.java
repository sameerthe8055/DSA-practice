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
        HashMap<TreeNode, Integer> map = new HashMap<>();
        solve(root, map);
        return map.get(root);
    }

    int solve(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        // rob = val + i+2
       int val = 0;
       if(root.left != null){
        val += solve(root.left.left, map) + solve(root.left.right, map);        
       }
       if(root.right != null){
        val += solve(root.right.left, map) + solve(root.right.right, map);
       }
       int robOrSkip = max(
        val + root.val,
        solve(root.left, map) + solve(root.right, map)
       );
       map.put(root, robOrSkip);

        return robOrSkip;

    }
}