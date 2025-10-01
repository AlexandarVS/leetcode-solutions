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
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode crr = head.next;
        ListNode next = crr.next;

        head.next = null;
        
        while(next != null){
            crr.next = prev;
            prev = crr;
            crr = next;
            next = next.next;
        }

        crr.next = prev;
        return crr;
    }
}