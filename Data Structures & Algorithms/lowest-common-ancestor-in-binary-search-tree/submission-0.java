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

        TreeNode temp = null;
        
        while(root != null)
        {
            if(root.val == p.val || root.val == q.val)
            {
                temp = root;
                break;
            }
            
            else if(p.val < root.val && q.val < root.val)
                root = root.left;

            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            
            // else if(p.val > root.val)
            else
            {
                temp = root;
                break;
            }
                
            
        }

        return temp;
    }
}