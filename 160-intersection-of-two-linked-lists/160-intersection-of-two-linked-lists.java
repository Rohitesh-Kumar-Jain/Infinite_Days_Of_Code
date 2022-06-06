/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int d = 0, e = 0, f;
        
        ListNode cur = headA;
        while(cur != null) {
            cur = cur.next; d++;
        }
        
        cur = headB;
        while(cur != null) {
            cur = cur.next; e++;
        }
        
        f = d - e;
        
        if (f > 0) {
            for (int i = f; i > 0; i--) {
                if (headA == null) break;
                headA = headA.next;
            }
            
        } else {
            f = Math.abs(f);
            for (int i = f; i > 0; i--) {
                if (headB == null) break;
                headB = headB.next;
            }
        }
        
        // System.out.println(d + " " + e + " " + f);
        
        while(headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}