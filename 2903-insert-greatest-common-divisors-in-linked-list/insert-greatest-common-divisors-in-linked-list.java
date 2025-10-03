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
    public int GCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode crr = head.next;
        ListNode prev = head;

        while(crr != null){
            int newNodeVal = GCD(prev.val, crr.val);
            prev.next = new ListNode(newNodeVal, crr);
            prev = crr;
            crr = crr.next;
        }

        return head;
    }
}