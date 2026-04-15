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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        // ListNode tail;
        int len = 0;

        List<Integer> arrList = new ArrayList<>();
        while(curr != null)
        {
            arrList.add(curr.val);
            curr = curr.next;
            len++;
        }
        List<Integer> resList = new ArrayList<>(len);

        
        curr = head;
        
        int front = 0;
        int back = len - 1;
        int i = 0;
        while(front <= back)
        {
            if( i % 2 == 0)
            {
                resList.add(arrList.get(front));
                front++;
            }
            else
            {
                resList.add(arrList.get(back));
                back--;
            }
            i++;
        }

        for(i = 1 ; i < len ; i++)
        {
            int value = resList.get(i);
            ListNode newNode = new ListNode(value);
            curr.next = newNode;
            curr = newNode;
        }

        // head = head.next;


    
    }
}