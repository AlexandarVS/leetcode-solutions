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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode crr = head;
        int size = 0;
        while(crr != null){
            crr = crr.next;
            size++;
        }

        k %= size;

        if(k == 0){
            return head;
        }
        
        crr = head;
        ListNode prev = null;

        while(crr != null && k != 0){
            if(crr.next == null){
                crr.next = head;
                prev.next = null;
                head = crr;
                k--;
            }else{
                prev = crr;
                crr = crr.next;
            }
        }

        return head;
    }
}