1class Solution {
2public:
3    int findMin(vector<int>& nums) 
4    {
5        int left= 0, right=nums.size()-1;
6        return binary_search(left, right,nums);
7
8    }
9    int binary_search(int left, int right , vector<int>& nums)
10    {
11        if(left == right)
12            return nums[right];
13        else if(right- left == 1)
14        {
15            return min(nums[left], nums[right]);
16        }
17
18        int mid = (left+right)/2;
19
20        if(nums[mid] >= nums[right])
21            return binary_search(mid, right, nums);
22        else
23            return binary_search(left, mid, nums);
24    }
25};