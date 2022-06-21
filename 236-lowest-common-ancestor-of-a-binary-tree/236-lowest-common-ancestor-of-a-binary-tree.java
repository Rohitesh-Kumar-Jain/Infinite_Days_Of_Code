/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        getPath(root, p, list1);
        getPath(root, q, list2);
        
        int i = 0, j = 0;
        
        while(i < list1.size() && j < list2.size()) {
            if (list1.get(i).val == list2.get(j).val) {
                i++; j++;
            } else {
                break;
            }
        }
        
        return list1.get(i-1);
    }
    
    private boolean getPath(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) return false;

        list.add(root);
        
        if(root == target) return true;
        
        boolean left = getPath(root.left, target, list);
        boolean right = getPath(root.right, target, list);
        
        if ((left || right) == false) list.remove(list.size() - 1);
        
        return left || right;
    }
}