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
    public ListNode getSecondHalf(ListNode head){
        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode secondHalf = reverse(getSecondHalf(head));
        ListNode fast = head;
        int maxSum = 0;
        while(secondHalf != null){
            if(head.val + secondHalf.val > maxSum){
                maxSum = head.val + secondHalf.val;
            }
            secondHalf = secondHalf.next;
            head = head.next;
        }

        return maxSum;
    }
}