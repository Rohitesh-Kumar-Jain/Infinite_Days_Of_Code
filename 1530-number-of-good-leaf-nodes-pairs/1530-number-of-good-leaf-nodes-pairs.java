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
    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> leaves = new HashSet<>();
    int val;
    
    public int countPairs(TreeNode root, int distance) {
        this.val = 0;
        changeVal(root);
        inorder(root, null);
        int ans = 0;
        
        for (Integer leaf : leaves) {
            Queue<Integer> bfs = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            bfs.add(leaf);
            int d = 0;
            while(bfs.size() > 0) {
                int k = bfs.size();
                for (int t = 0; t < k; t++) {
                    int cur = bfs.poll();
                    if (seen.contains(cur)) continue;
                    seen.add(cur);
                    
                    if (leaves.contains(cur) && cur != leaf) ans++;
                    
                    for (int node : graph.get(cur)) {
                        bfs.add(node);
                    }
                }
                d++;
                if (d > distance) break;
            }
        }
        
        return ans/2;
    }
    
    private void changeVal(TreeNode root) {
        if (root == null) return;
        
        changeVal(root.left);
        root.val = val++;
        changeVal(root.right);
    }
    
    private void inorder(TreeNode root, TreeNode parent) {
        if (root == null) return;
        
        inorder(root.left, root);
        
        // System.out.println(root.val);
        
        graph.putIfAbsent(root.val, new ArrayList<>());
        if (root.left != null) graph.get(root.val).add(root.left.val);
        if (root.right != null) graph.get(root.val).add(root.right.val);
        if (parent != null) graph.get(root.val).add(parent.val);
        
        if (root.left == null && root.right == null) leaves.add(root.val);
        
        inorder(root.right, root);
    }
}