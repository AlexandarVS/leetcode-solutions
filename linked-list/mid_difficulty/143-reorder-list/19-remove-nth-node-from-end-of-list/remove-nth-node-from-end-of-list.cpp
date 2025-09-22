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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head == nullptr){
            return head;
        }

        if(head->next == nullptr && n == 1){
            return nullptr;
        }

        ListNode* temp = head;
        int len = 0;
        while(temp != nullptr){
            temp = temp->next;
            len++;
        }

        int nodeIndex = len - n;

        if(nodeIndex == 0){
            ListNode* toDelete = head;
            head = head->next;
            delete toDelete;
            return head;
        }

        ListNode* crr = head;
        ListNode* prev = head;
        int count = 0;
        while(crr != nullptr && count <= nodeIndex){
            if(count == nodeIndex){
                ListNode* toDelete = crr;
                prev->next = crr->next;
                crr = crr->next;
                delete toDelete;
            }else{
                prev = crr;
                crr = crr->next;
            }
            count++;
        }
        return head;
    }
};