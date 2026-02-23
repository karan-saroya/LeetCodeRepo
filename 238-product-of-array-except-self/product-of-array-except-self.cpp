class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) 
    {
        vector<int> pre_product, post_product,answer;
        int pre_prod=1, post_prod=1;
        for(int i=0;i<nums.size();i++)
        {
            pre_product.push_back(pre_prod);
            pre_prod*=nums[i];
        }
        for(int i = nums.size() - 1;i >= 0;i--)
        {
            post_product.insert(post_product.begin(), post_prod);
            post_prod*=nums[i];
        }
        for(int i = 0; i < pre_product.size(); i++)
        {
            answer.push_back(pre_product[i]*post_product[i]);
        }
        return answer;
        
    }
};