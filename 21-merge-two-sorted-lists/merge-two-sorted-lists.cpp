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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(list1 == nullptr && list2 == nullptr){
            return nullptr;
        }

        if(list1 == nullptr || list2 == nullptr){
            return list1 == nullptr ? list2 : list1;
        }

        ListNode* crrFirst = list1;
        ListNode* crrSecond = list2;
        ListNode* result = nullptr;

        if(crrFirst->val < crrSecond->val){
                result = crrFirst;
                crrFirst = crrFirst->next;
        }else{
                result = crrSecond;
                crrSecond = crrSecond->next;
        }

        ListNode* head = result;

        while(crrFirst != nullptr && crrSecond != nullptr){
            if(crrFirst->val < crrSecond->val){
                result->next = crrFirst;
                crrFirst = crrFirst->next;
            }else{
                result->next = crrSecond;
                crrSecond = crrSecond->next;
            }

            result = result->next;
        }

        if(crrFirst != nullptr){
            result->next = crrFirst;
        }

        if(crrSecond != nullptr){
            result->next = crrSecond;
        }

        return head;
    }
};