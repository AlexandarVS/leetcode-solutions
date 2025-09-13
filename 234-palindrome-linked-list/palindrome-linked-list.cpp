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

    ListNode* reverse(ListNode* head){
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
    bool isPalindrome(ListNode* head) {
        if(head == nullptr || head->next == nullptr){
            return true;
        }

        ListNode* middle = head;
        ListNode* fast = head;
        while(fast != nullptr && fast->next != nullptr){
           middle = middle->next;
           fast = fast->next->next;
        }

        middle = reverse(middle);
        ListNode* crr = head;
        while(middle != nullptr){
            if(middle->val != crr->val){
                return false;
            }

            crr = crr->next;
            middle = middle->next;
        }

        return true;
    }
};