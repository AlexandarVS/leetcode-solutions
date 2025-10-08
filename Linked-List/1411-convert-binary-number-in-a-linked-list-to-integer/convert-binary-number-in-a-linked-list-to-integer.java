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
    public int getDecimalValue(ListNode head) {
        if(head == null){
            return 0;
        }

        ListNode crr = head;
        int size = 0;
        int result = 0;

        while(crr != null){
            size++;
            crr = crr.next;
        }

        crr = head;

        while(crr != null){
            result += crr.val * Math.pow(2, size - 1);
            crr = crr.next;
            size--;
        }

        return result;
    }
}