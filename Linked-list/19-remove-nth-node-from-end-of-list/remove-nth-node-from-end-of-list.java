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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode crr = head;
        while(crr != null){
            crr = crr.next;
            size++;
        }

        crr = head;
        int indexToRemove = size - n;
        int iter = 1;

        if (indexToRemove == 0) {
            return head.next;
        }

        while(crr != null){
            if(crr.next != null && iter == indexToRemove){
                crr.next = crr.next.next;
                break;
            }
            crr = crr.next;
            iter++;
        }

        return head;
    }
}