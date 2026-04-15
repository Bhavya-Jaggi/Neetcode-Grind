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
    public boolean isValidBST(TreeNode root) {
        
        long minValue = Long.MIN_VALUE; //long is used because this leetcode gives 2^32 - 1 as input so use more less value to counter that!
        long maxValue = Long.MAX_VALUE;

        return whatTheHellBST(root , minValue , maxValue); //Call the helper func

    }

    public boolean whatTheHellBST(TreeNode root , long minValue , long maxValue)
    {
        if(root == null) //End of node then it's valid
            return true;
        
        if(root.val <= minValue || root.val >= maxValue) //violates the min and max value at any moment makes it invalid
            return false;


            
        /* * THE DELEGATION & BOUNDARY UPDATE
         * We must verify that both the left AND right branches strictly follow BST rules.
         * * PART 1: THE LEFT BRANCH -> whatTheHellBST(root.left, minValue, root.val)
         * - Rule: Every single node to the left MUST be smaller than our current node.
         * - Action: We keep the floor (minValue) the same, but our current node's value 
         * (root.val) becomes the NEW strict ceiling (maxValue) for this entire branch.
         * * PART 2: THE RIGHT BRANCH -> whatTheHellBST(root.right, root.val, maxValue)
         * - Rule: Every single node to the right MUST be larger than our current node.
         * - Action: Our current node's value (root.val) becomes the NEW strict floor (minValue)
         * for this entire branch, while the ceiling (maxValue) stays the same.
         * * PART 3: THE && (AND) OPERATOR
         * - The current tree is ONLY valid if the entire left side reports 'true' 
         * AND the entire right side reports 'true'. If even one node deep down 
         * violates a boundary, it returns false, and the && forces the whole tree to fail.
         */
        return whatTheHellBST(root.left, minValue, root.val) && 
               whatTheHellBST(root.right, root.val, maxValue);
    }
}