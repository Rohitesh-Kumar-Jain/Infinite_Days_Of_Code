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
    
    List<Integer> list = new ArrayList<>();
    int j = 0;
    
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        
        for (int i = list.size() - 2; i >= 0; i--) {
            list.set(i, list.get(i + 1) + list.get(i));
        }
        
        update(root);
        
        return root;
    }
    
    private void update(TreeNode root) {
        if (root == null) return;
        
        update(root.left);
        root.val = list.get(j++);
        update(root.right);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}