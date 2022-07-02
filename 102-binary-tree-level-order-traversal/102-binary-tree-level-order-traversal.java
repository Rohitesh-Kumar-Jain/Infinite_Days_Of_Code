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
    List<List<Integer>> ans = new ArrayList<>();
    
    public void level(TreeNode root, int h){
        if(root == null) return;
        if(h == ans.size()) ans.add(new ArrayList<>());
        ans.get(h).add(root.val);
        level(root.left,h+1);
        level(root.right,h+1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        level(root,0);
        return ans;
    }
}