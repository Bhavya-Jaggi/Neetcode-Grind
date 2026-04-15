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

    int flag = 1;
    public boolean isSameTree(TreeNode p, TreeNode q) {

        isSameTreeRec(p ,q);
        // isSameTreeRec(q);

        if(flag == 1)
            return true;
        else
            return false;

    }

    public void isSameTreeRec(TreeNode p , TreeNode q)
    {
        if(p == null & q == null)
            return;
        if(p == null || q == null)
        {
            flag = 0;
            return;
        }

        if(p.val != q.val)
            flag = 0;
        
        else
        {
            isSameTreeRec(p.left , q.left);
            isSameTreeRec(p.right , q.right);
        }
    }
}