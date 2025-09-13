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
     ListNode* reverseList(ListNode* head) {
        if(head == nullptr){
            return nullptr;
        }

        if(head->next == nullptr){
            return head;
        }

        ListNode* crr = head->next;
        ListNode* next = head->next->next;
        ListNode* prev = head;

        head->next = nullptr;
        
        while(next != nullptr){
            crr->next = prev;
            prev = crr;
            crr = next;
            next = next->next;
        }

        crr->next = prev;
        return crr;
    }

    ListNode* middleNode(ListNode* head) {
        if(head == nullptr){
            return nullptr;
        }

        if(head->next == nullptr){
            return head;
        }

        ListNode* middle = head;
        ListNode* fast = head;

        while(fast != nullptr && fast->next != nullptr){
            middle = middle->next;
            fast = fast->next->next;
        }
        return middle;
    }

    void reorderList(ListNode* head) {
        if(head == nullptr){
            return;
        }

        ListNode* middle = reverseList(middleNode(head));

        ListNode* crr = head;
        ListNode* crrNext = head->next;
        ListNode* middleNext = middle->next;

        while(middleNext != nullptr && crrNext != nullptr){
            crr->next = middle;
            crr = crrNext;

            middle->next = crr;
            middle = middleNext;

            crrNext = crrNext->next;
            middleNext = middleNext->next;
        }
    }
};