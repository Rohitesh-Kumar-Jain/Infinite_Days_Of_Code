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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorder(list,root);
        TreeNode bst = new TreeNode(0);
        TreeNode gst= bst;
        for(int i: list){
            bst.right= new TreeNode(i);
            bst=bst.right;
        }
        return  gst.right;
    }
    public void inorder(List<Integer> list, TreeNode root){
        if(root==null) return ;
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
}