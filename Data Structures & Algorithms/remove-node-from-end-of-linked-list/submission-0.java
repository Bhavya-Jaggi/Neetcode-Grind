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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cpy = head;

        int len = 0;
        while(cpy != null)
        {
            len++;
            cpy = cpy.next;
        }

        n = len - n + 1;
        cpy = head;

        if( len == 1)
            return null;

        else if( n == len )
        {
            for(int i = 1; i < n - 1 ; i++)
            {
                cpy = cpy.next;
            }
            cpy.next = null;
            return head;
        }

        else if( n == 1)
        {
            head = head.next;
            return head;
        }


        else
        {
            int i = 1;
            while(i < n - 1)
            {
                cpy = cpy.next;
                i++;
            }
            cpy.next = cpy.next.next;
        }
        return head;
    }
}