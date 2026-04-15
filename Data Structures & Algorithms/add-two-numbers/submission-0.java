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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode list3 = new ListNode(-1);
        ListNode cpy = list3;

        while(list1 != null && list2 != null)
        {
            int value1 = list1.val;
            int value2 = list2.val;

            int sum = value1 + value2;

            if(carry == 1)
            {
                sum += 1;
                carry = 0;
            }

            if(sum > 9)
            {
                carry = 1;
                ListNode newNode = new ListNode(sum % 10);
                cpy.next = newNode;
                cpy = cpy.next;
            }
            else
            {
                ListNode newNode = new ListNode(sum);
                cpy.next = newNode;
                cpy = cpy.next;
            }
            list1 = list1.next;
            list2 = list2.next;
            
        }

        while(list1 != null)
        {
            int value1 = list1.val;
            if(carry == 1)
            {
                value1 += 1;
                carry = 0;
            }

            if(value1 > 9)
            {
                ListNode newNode = new ListNode(value1 % 10);
                carry = 1;
                cpy.next = newNode;
                cpy = cpy.next;
            }
            else if(value1 <= 9)
            {
                carry = 0;
                ListNode newNode = new ListNode(value1);
                cpy.next = newNode;
                cpy = cpy.next;
            }


            list1 = list1.next;
        }


        while(list2 != null)
        {
            int value2 = list2.val;
            if(carry == 1)
            {
                value2 += 1;
                carry = 0;
            }
            if(value2 > 9)
            {
                ListNode newNode = new ListNode(value2 % 10);
                carry = 1;
                cpy.next = newNode;
                cpy = cpy.next;
            }
            else if(value2 <= 9)
            {
                carry = 0;
                ListNode newNode = new ListNode(value2);
                cpy.next = newNode;
                cpy = cpy.next;
            }


            list2 = list2.next;
        }


        if(carry == 1)
        {
            ListNode newNode = new ListNode(1);
            cpy.next = newNode;
            cpy = cpy.next;
        }




        list3 = list3.next;
        return list3;
    }
}