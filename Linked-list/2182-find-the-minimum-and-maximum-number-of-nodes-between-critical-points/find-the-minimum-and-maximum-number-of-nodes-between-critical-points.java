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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;
        ListNode prev = head;
        ListNode crr = head.next;
        ListNode next = crr.next;
        int nodeNumber = 1;
        int firstCritical = -1;
        int lastCritical = -1;

        while(next != null){
            if(prev.val > crr.val && next.val > crr.val || prev.val < crr.val && next.val < crr.val){
                if(firstCritical == -1){
                    firstCritical = nodeNumber;
                }else{
                    minDistance = Math.min(minDistance, nodeNumber - lastCritical);
                }

                lastCritical = nodeNumber;
            }

            prev = crr;
            crr = next;
            next = next.next;
            nodeNumber++;
        }

        int maxDistance = lastCritical - firstCritical;
        if (firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }
        return new int[]{minDistance,maxDistance};
    }
}