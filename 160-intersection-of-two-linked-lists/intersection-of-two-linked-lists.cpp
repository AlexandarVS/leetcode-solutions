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
        ListNode* crrB = headB;

        while(crrA != nullptr && crrB != nullptr && crrA != crrB){
            crrA = crrA->next;
            crrB = crrB->next;

            if(crrA == crrB){
                return crrA;
            }

            if(crrA == nullptr){
                crrA = headB;
            }

            if(crrB == nullptr){
                crrB = headA;
            }
        }
        return crrA;
    }
};