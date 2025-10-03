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
    public ListNode mergeNodes(ListNode head) {
        ListNode crr = head.next;
        int sumNodes = 0;

        ListNode result = new ListNode(0);
        ListNode crrResult = result;
        
        while(crr != null){
            if(crr.val != 0){
                sumNodes += crr.val;
            }else{
                crrResult.next = new ListNode(sumNodes);
                crrResult = crrResult.next;
                sumNodes = 0;
            }

            crr = crr.next;
        }

        return result.next;
    }
}