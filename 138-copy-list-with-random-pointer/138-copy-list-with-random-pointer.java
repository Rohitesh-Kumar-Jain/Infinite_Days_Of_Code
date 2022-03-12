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
        
        if (head == null) return null;
        
        Map<Node, Node> map = new HashMap<>();

        Node head2 = new Node(-1);
        Node prev = head2;
        Node cur = head;
        
        while(cur != null) {
            if (!map.containsKey(cur)) {
                Node temp = new Node(cur.val);
                map.put(cur, temp);
            }
            
            Node temp = map.get(cur);
            prev.next = temp;
            
            if (!map.containsKey(cur.random)) {
                Node tempRand = null;
                if (cur.random != null) tempRand = new Node(cur.random.val);
                map.put(cur.random, tempRand);
            }
            
            temp.random = map.get(cur.random);
            cur = cur.next;
            prev = prev.next;
        }
        
        Node travel = head2;
        head2 = head2.next;
        
        return head2;
    }
}