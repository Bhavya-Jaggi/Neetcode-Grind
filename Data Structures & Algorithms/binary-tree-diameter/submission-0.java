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

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int res = maxDepthRec(root);
        return maxDiameter;
    }

    public int maxDepthRec(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int left = maxDepthRec(root.left);
        int right = maxDepthRec(root.right);

        if(left + right > maxDiameter)
            maxDiameter = left + right;
        
        return Math.max(left , right) + 1;
    }
}