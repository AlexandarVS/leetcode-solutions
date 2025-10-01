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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }

        if(list1 == null || list2 == null){
            return list1 != null ? list1 : list2;
        }

        ListNode crrFirst = list1;
        ListNode crrSecond = list2;

        ListNode result = null;

        if(crrFirst.val < crrSecond.val){
            result = crrFirst;
            crrFirst = crrFirst.next;
        }else{
            result = crrSecond;
            crrSecond = crrSecond.next;
        }

        ListNode head = result;

        while(crrFirst != null && crrSecond != null){
            if(crrFirst.val <= crrSecond.val){
                result.next = crrFirst;
                crrFirst = crrFirst.next;
            }else{
                result.next = crrSecond;
                crrSecond = crrSecond.next;
            }

            result = result.next;
        }

        if(crrFirst == null && crrSecond != null){
            result.next = crrSecond;
        }

        if(crrFirst != null && crrSecond == null){
            result.next = crrFirst;
        }

        return head;
    }
}