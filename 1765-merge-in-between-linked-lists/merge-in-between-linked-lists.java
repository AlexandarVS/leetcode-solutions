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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode crrFirst = list1;
        while(crrFirst != null && crrFirst.next != null){
            if(a > 1){
                crrFirst = crrFirst.next;
                --a;
                --b;
            }else if(b > 0){
                crrFirst.next = crrFirst.next.next;
                --b;
            }

            if(a == 1 && b == 0){
                break;
            }
        }

        ListNode temp = crrFirst.next;
        crrFirst.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = temp;

        return list1;
    }
}