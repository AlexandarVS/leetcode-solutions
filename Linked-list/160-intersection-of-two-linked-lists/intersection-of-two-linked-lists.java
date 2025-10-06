/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode crrFirst = headA;
        ListNode crrSecond = headB;

        while (crrFirst != crrSecond) {
            crrFirst = (crrFirst == null) ? headB : crrFirst.next;
            crrSecond = (crrSecond == null) ? headA : crrSecond.next;
        }

        return crrFirst;
    }
}