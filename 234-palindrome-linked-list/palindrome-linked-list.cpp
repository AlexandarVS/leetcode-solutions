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

        ListNode* prev = nullptr;

        while(middle != nullptr){
            ListNode* middleNext = middle->next;
            middle->next = prev;
            prev = middle;
            middle = middleNext;
        }

        ListNode* firstHalf = head;
        ListNode* secondHalf = prev;

        while(secondHalf != nullptr){
            if(firstHalf->val != secondHalf->val){
                return false;
            }

            firstHalf = firstHalf->next;
            secondHalf = secondHalf->next;
        }

        return true;
    }
};