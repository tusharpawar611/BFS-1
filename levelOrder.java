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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root,res,0);
        
        return res;
    }
    
    void helper(TreeNode node, List<List<Integer>> res, int level){
        
        if(node==null)
            return;
        
        if(res.size()<=level){
            res.add(new ArrayList());
        }
        
        
            res.get(level).add(node.val);
        
        
        helper(node.left,res,level+1);
        helper(node.right,res,level+1);
        
        
    }
}