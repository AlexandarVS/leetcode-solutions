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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == nullptr){
            return nullptr;
        }

        while(head->next != nullptr && head->val == head->next->val){
            ListNode* toDelete = head;
            head = head->next;
            delete toDelete;
        }

        ListNode* crr = head;
        ListNode* prev = head;
        while(crr != nullptr && crr->next != nullptr){
            if(crr->val == crr->next->val){
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