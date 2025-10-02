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

        ListNode crr = head;

        while(crr != null && crr.next != null){
            if(crr.val == crr.next.val){
                crr.next = crr.next.next;
            }else{
                crr = crr.next;
            }
        }

        return head;
    }
}