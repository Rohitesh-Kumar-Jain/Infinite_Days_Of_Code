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
        inorder(root, 0);
        for (int i = list.size() - 2; i >= 0; i--) list.set(i, list.get(i + 1) + list.get(i));
        inorder(root, 1);
        return root;
    }
    
    private void inorder(TreeNode root, int flag) {
        if (root == null) return;
        
        inorder(root.left, flag);
        if (flag == 0) list.add(root.val);
        else root.val = list.get(j++);
        inorder(root.right, flag);
    }
}