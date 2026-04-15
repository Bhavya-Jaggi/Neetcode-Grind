/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        boolean huh;
        ListNode curr = head;
        while(curr != null)
        {
            huh = set.add(curr.next);
            if(!huh)
                return true;
            curr = curr.next;

        }
        return false;
    }
}