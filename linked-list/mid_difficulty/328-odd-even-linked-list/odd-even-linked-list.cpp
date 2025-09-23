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
    ListNode* oddEvenList(ListNode* head) {
        if(head == nullptr || head->next == nullptr){
            return head;
        }

        ListNode* odds = head;
        ListNode* evens = head->next;

        ListNode* crrOdds = odds;
        ListNode* crrEvens = evens;

        while(crrEvens != nullptr && crrEvens->next != nullptr){
            crrOdds->next = crrEvens->next;
            crrOdds = crrOdds->next;

            crrEvens->next = crrOdds->next;
            crrEvens = crrEvens->next;
        }

        crrOdds->next = evens;
        return head;
    }
};