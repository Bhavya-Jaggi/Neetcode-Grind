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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        boolean t = false;
        if(root.val == subRoot.val)
        {
             t = isSametree(root , subRoot);
        }
        if(t == true)
            return true;
        boolean t1 = isSubtree(root.left , subRoot);
        boolean t2 = isSubtree(root.right , subRoot);

        if(t1 == true || t2 == true)
            return true;
        
        return false;


    }



    public boolean isSametree(TreeNode root, TreeNode subRoot) {
        
        if(root == null && subRoot == null)
            return true;
        
        if(root == null || subRoot == null)
            return false;
        
        if(root.val != subRoot.val)
            return false;

        return (isSametree(root.left , subRoot.left) && isSametree(root.right , subRoot.right));
    }
}