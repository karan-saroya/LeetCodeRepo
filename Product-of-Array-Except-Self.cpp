1class Solution {
2public:
3    vector<int> productExceptSelf(vector<int>& nums) 
4    {
5        vector<int> pre_product, post_product,answer;
6        int pre_prod=1, post_prod=1;
7        for(int i=0;i<nums.size();i++)
8        {
9            pre_product.push_back(pre_prod);
10            pre_prod*=nums[i];
11        }
12        for(int i = nums.size() - 1;i >= 0;i--)
13        {
14            post_product.insert(post_product.begin(), post_prod);
15            post_prod*=nums[i];
16        }
17        for(int i = 0; i < pre_product.size(); i++)
18        {
19            answer.push_back(pre_product[i]*post_product[i]);
20        }
21        return answer;
22        
23    }
24};