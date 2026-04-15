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
    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;
        
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        if(leftHeight < 0 || rightHeight <0)
            return false;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return true;
        
    }

    public int heightRec(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -100000; //Bad approach since imagine both sides are (-10^5) then Math.abs(left, right) will be 10^5 - 10^5 = 0 and 0 > 1 i false
            //So then bascially i am returning -10^5 + 1 = -99999 which is still soo soo much < 0 that code somehow works!

        return Math.max(leftHeight , rightHeight) + 1;
    }
}