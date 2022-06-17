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
    
    Set<TreeNode> camera = new HashSet<>();
    Set<TreeNode> covered = new HashSet<>();
    int ans = 0;
    
    public int minCameraCover(TreeNode root) {
        
        postOrder(root, root);
        
        // System.out.println(camera);
        
        return ans;
    }
    
    private void postOrder(TreeNode root, TreeNode parent) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            covered.add(root);
            if (camera.contains(parent)) return;
            camera.add(parent); ans++;
            covered.add(parent);
            return;
        }
        
        postOrder(root.left, root);
        postOrder(root.right, root);
        
        if (camera.contains(root)) {
            covered.add(parent); 
            return;
        }
        
        if (root != parent && (root.left == null || covered.contains(root.left)) && (root.right == null || covered.contains(root.right))) return;
        
        if (covered.contains(root) && (root.left == null || covered.contains(root.left)) && (root.right == null || covered.contains(root.right))) return;
        
        camera.add(root);
        covered.add(root); covered.add(parent);
        if (root.left != null) covered.add(root.left);
        if (root.right != null) covered.add(root.right);
        ans++;
    }
}