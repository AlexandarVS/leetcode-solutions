/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        if(head == nullptr){
            return nullptr;
        }

        while(head != nullptr && head->val == val){
            ListNode* toDelete = head;
            head = head->next;
            delete toDelete;
        }

        ListNode* crr = head;
        ListNode* prev = head;
        while(crr != nullptr){
            if(crr->val == val){
                ListNode* toDelete = crr;
                prev->next = crr->next;
                crr = crr->next;
                delete toDelete;
            }else{
                prev = crr;
                crr = crr->next;
            }
        }

        return head;
    }
};