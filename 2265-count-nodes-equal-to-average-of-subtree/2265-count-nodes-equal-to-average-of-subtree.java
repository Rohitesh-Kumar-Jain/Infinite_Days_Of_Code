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
class Solution {
    
    int ans = 0;
    
    public int averageOfSubtree(TreeNode root) {
        
        helper(root);
        return ans;
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int cur = root.val;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int avg = (left[0] + right[0] + cur)/(left[1] + right[1] + 1);
        
        if (avg == cur) ans++;
        
        return new int[]{left[0] + right[0] + cur, left[1] + right[1] + 1};
    }
}