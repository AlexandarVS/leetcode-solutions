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
    
    void split(ListNode* source, ListNode*& left, ListNode*& right) {
        if (source == nullptr || source->next == nullptr) {
            left = source;
            right = nullptr;
            return;
        }

        ListNode* slow = source;
        ListNode* fast = source->next;

        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        left = source;
        right = slow->next;
        slow->next = nullptr;
    }

    ListNode* merge(ListNode* first, ListNode* second) {
        if (first == nullptr) {
            return second;
        }

        if (second == nullptr) {
            return first;
        }

        if (first->val < second->val) {
            first->next = merge(first->next, second);
            return first;
        }
        else {
            second->next = merge(first, second->next);
            return second;
        }
    }
    ListNode* sortList(ListNode* head) {
        
        if (head == nullptr || head->next == nullptr) {
            return head; 
        }   

        ListNode* left;
        ListNode* right;

        split(head,left,right);

        left = sortList(left);
        right = sortList(right);

        return merge(left,right);
    }

};