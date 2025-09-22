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

   int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        if(head == nullptr){
            return nullptr;
        }

        ListNode* crr = head;
        ListNode* next = head->next;

        while(crr != nullptr && next != nullptr){
            int value = gcd(crr->val, crr->next->val);
            ListNode* newNode = new ListNode(value,next);
            crr->next = newNode;
            crr = newNode->next;
            next = next->next;
        }

        return head;
    }
};