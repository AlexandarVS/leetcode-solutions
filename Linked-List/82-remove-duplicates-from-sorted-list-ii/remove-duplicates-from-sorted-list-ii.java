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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode crr = dummy.next;
        ListNode prev = dummy;
        int temp = -101;

        while(crr != null){
            if(crr.next != null && crr.val == crr.next.val){
                temp = crr.val;
            }

            if (temp == crr.val) {
                prev.next = crr.next;
            } else {
                prev = prev.next;
            }
            crr = crr.next;
        }

        return dummy.next;
    }
}