/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA == nullptr || headB == nullptr){
            return nullptr;
        }

        ListNode* crrA = headA;
        while(crrA != nullptr){
             ListNode* crrB = headB;
            while(crrB != nullptr){
                if(crrA == crrB){
                    return crrA;
                }
                crrB = crrB->next;
            }
            crrA = crrA->next;
        }
    return nullptr;
    }
};