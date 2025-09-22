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

        ListNode* crr = head;
        ListNode* prev = nullptr;
        bool isDublicate = false;

        while(crr!= nullptr){
            isDublicate = false;
            while(crr->next != nullptr && crr->val == crr->next->val){
                isDublicate = true;
                crr->next = crr->next->next;
            }

            if(isDublicate){
                if(prev == nullptr){
                    head = head->next;
                    crr = crr->next;
                }else{
                    prev->next = crr->next;
                    crr = crr->next;
                }
            }else{
                prev = crr;
                crr = crr->next;
            }
        }
        return head;
    }
};