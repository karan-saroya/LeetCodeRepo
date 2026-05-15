1class Solution {
2public:
3    int search(vector<int>& nums, int target) 
4    {
5        int left=0, right= nums.size()-1;
6        return binary_search(left,right,target,nums);
7
8    }
9
10    int binary_search(int left, int right, int tar, vector<int>& nums)
11    {
12        //cout<<"Left: "<<left<<" Right:"<< right<<endl;
13        if(right -left  == 0 && left >=0 && right < nums.size())
14        {
15            if(nums[left] == tar)
16                return left;
17            return -1;
18
19        }
20        else if(right -left  == 0 )
21        {
22            return -1;
23        }
24        else if(right - left == 1)
25        {
26            if(nums[left] == tar)
27                return left;
28            else if(nums[right] == tar)
29                return right;
30            return -1;
31        }
32        
33
34        int mid = (left+right)/2;
35        
36        if(nums[mid] == tar)
37            return mid;
38        if(nums[mid] <tar && nums[mid] >= nums[right])
39        {
40           // cout<<"1"<<endl;
41            return binary_search(mid+1, right, tar, nums);
42        } 
43        else if(nums[mid] < tar && nums[mid] < nums[right])
44        {
45           // cout<<"2"<<endl;
46            if(tar > nums[right])
47                return binary_search(left, mid-1, tar, nums);
48            else 
49                return binary_search(mid+1, right, tar, nums);
50        }
51
52        else if(nums[mid] > tar && nums[mid] >= nums[right] )
53        {
54            //cout<<"3"<<endl;
55            if(tar < nums[left])
56                return binary_search(mid+1, right, tar, nums);
57            else
58                return binary_search(left, mid-1, tar, nums);
59        }
60        else
61        {
62            //cout<<"4"<<endl;
63            return binary_search(left, mid-1, tar, nums);
64        }
65        
66        
67
68    }
69};