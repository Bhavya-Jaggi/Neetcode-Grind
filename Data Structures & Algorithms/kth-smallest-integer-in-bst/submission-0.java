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

    int count = 0 , value = 0;

    public int kthSmallest(TreeNode root, int k) {

        traverseTree(root , k);

        

        return value;
        
    }

    public void traverseTree(TreeNode root , int k)
    {
        if(root == null)
            return;
        
        if(root.left != null)
            traverseTree(root.left , k);
        
        count++;
        if(count == k)
        {
            value = root.val;
            return;
        }

        if(root.right != null)
            traverseTree(root.right , k);

    }
}