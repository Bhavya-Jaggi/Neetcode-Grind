/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        

        Map<Node , Node> listMap = new HashMap<>();

        while(curr != null)
        {
            listMap.put(curr , new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr != null)
        {
            Node cpy = listMap.get(curr);

            cpy.next = listMap.get(curr.next);

            cpy.random = listMap.get(curr.random);

            curr = curr.next;
        }
        return listMap.get(head);
    }
}