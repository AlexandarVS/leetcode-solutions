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
    int getSize(ListNode* head){
        if(head == nullptr){
            return 0;
        }

        int size = 0;

        while(head != nullptr){
            size++;
            head = head->next;
        }

        return size;
    }

    int getDecimalValue(ListNode* head) {
        if(head == nullptr){
            return 0;
        }
        ListNode* crr = head;
        int binaryNumber = 0;
        int power = getSize(head) - 1;
        while(crr != nullptr){
            if(crr->val == 1){
                binaryNumber += pow(2,power);
            }

            power--;
            crr = crr->next;
        }
        return binaryNumber;
    }
};