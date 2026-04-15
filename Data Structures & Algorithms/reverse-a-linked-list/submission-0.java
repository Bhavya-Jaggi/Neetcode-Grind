/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = head.next;

        curr.next = null; //This is crucial as soon as i return on the 1st node(starting from the end it's last node) when i reach 2nd last node(2nd node) it points to last node(1st node) when i am at this node i never changed it's next(which from the very beginning points to 2nd node 1-> 2) so i infinitely loop from last and 2nd last nodes (1st and 2nd nodes) it can also be done by head.next = null{Why u ask cuz pointers are refrences when you change ref using 'curr' now 'head' uses the same reference}
        while(nxt != null)
        {
            prev = curr;
            curr = nxt;
            nxt = nxt.next; //This should be done earlier than the below step cuz if u reverse these two steps again curr.next = prev makes 'nxt' also point to prev cuz 'curr' and 'nxt' are just references to a particualr ListNode 
            curr.next = prev;
        }

        return curr;

    }
}