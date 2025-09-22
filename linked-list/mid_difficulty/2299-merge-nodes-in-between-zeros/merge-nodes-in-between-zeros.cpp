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

    ListNode* extractNode(ListNode* head){
        if(head == nullptr){
            return nullptr;
        }

        ListNode* crr = head->next;
        int sum = 0;
        while(crr != nullptr && crr->val != 0){
            sum+= crr->val;
            crr = crr->next;
        }

        return new ListNode(sum);
    }

    ListNode* mergeNodes(ListNode* head) {
        if(head == nullptr){
            return nullptr;
        }

        ListNode* crr = head->next;
        ListNode* result = extractNode(head);
        ListNode* crrResult = result;
        while(crr != nullptr){
            if(crr->val == 0 && crr->next != nullptr){
                crrResult->next = extractNode(crr);
                crrResult = crrResult->next;
            }

            crr = crr->next;
        }

        return result;
    }
};