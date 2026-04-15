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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        if(root == null)
            return res;

        queue.offer(root);

        while(!queue.isEmpty())
        {
            int lvl = queue.size();

            for(int i = 0 ; i < lvl ; i++)
            {
                TreeNode curr = queue.poll();
                if(i == lvl - 1)
                    res.add(curr.val);

                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
            }

        }
        return res;
    }
}