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
    public int goodNodes(TreeNode root) {

        int maxValue = root.val;
        return dfs(root , maxValue);
  
    }

    int count = 0;
    public int dfs(TreeNode root , int maxValue)
    {
        if(root == null)
            return 0;
        

        if(root.val >= maxValue)
        {
            count++;
            maxValue = root.val;
        }

        dfs(root.left , maxValue);
        dfs(root.right , maxValue);

        return count;
    }

    
}