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


 //Such a stupid logic wtf!
public class Solution {
    public boolean hasCycle(ListNode head) {

        Set<ListNode> hashSet = new HashSet<>();
        boolean t = true;

        while(head != null)
        {
            t = hashSet.add(head.next);
            if(!t)
                break;
            head = head.next;
        }
        return !t;
    }
}