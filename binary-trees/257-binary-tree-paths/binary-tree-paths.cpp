/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void helper(vector<string>& result, TreeNode* root, string path = ""){
        if(root == nullptr){
            return;
        }

        if(root->left == nullptr && root->right == nullptr){
            path += to_string(root->val);
            result.push_back(path);
            path = "";
        }

        path += to_string(root->val) + "->";
        helper(result, root->left, path);
        helper(result, root->right, path);
    }

    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        helper(result, root);
        return result;
    }
};