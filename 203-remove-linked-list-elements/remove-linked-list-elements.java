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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode crr = dummy;

        while(crr != null && crr.next != null){
            if(crr.next.val == val){
                crr.next = crr.next.next;
            }else{
                crr = crr.next;
            }
        }

        return dummy.next;
    }
}