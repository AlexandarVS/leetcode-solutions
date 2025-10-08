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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode crr = head;

        while(crr != null){
            ListNode next = crr.next;
            crr.next = prev;
            prev = crr;
            crr = next;
        }

        ListNode newHead = prev;
        ListNode temp = newHead;
        int maxValue = temp.val;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(temp != null){
            if(temp.val >= maxValue){
                maxValue = temp.val;
                tail.next = temp;
                tail = tail.next;
            }
            temp = temp.next;
        }

        tail.next = null;

        prev = null;
        crr = dummy.next;
        while (crr != null) {
            ListNode next = crr.next;
            crr.next = prev;
            prev = crr;
            crr = next;
        }
        return prev;
    }
}