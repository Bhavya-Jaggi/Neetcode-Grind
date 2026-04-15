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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(-1);
        ListNode curr = list3;

        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        while(list1 != null && list2 != null)
        {
            int val1 = list1.val;
            int val2 = list2.val;

            if(val1 == val2)
            {
                ListNode newNode = new ListNode(val1);
                curr.next = newNode;
                curr = newNode;
                list1 = list1.next;
            }
            else if(val1 > val2)
            {
                ListNode newNode = new ListNode(val2);
                curr.next = newNode;
                curr = newNode;
                list2 = list2.next;
            }
            else
            {
                ListNode newNode = new ListNode(val1);
                curr.next = newNode;
                curr = newNode;
                list1 = list1.next;
            }
        }

        while(list1 != null)
        {
            curr.next = list1;
            curr = list1;
            list1 = list1.next;
        }

        while(list2 != null)
        {
            curr.next = list2;
            curr = list2;
            list2 = list2.next;
        }

        return list3.next;
    }
}