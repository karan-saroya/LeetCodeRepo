1class Solution {
2      public int longestOnes(int[] nums, int k)
3    {
4        int l=0, r=0, zerosCount = 0, ans =0;
5        for(r=0; r< nums.length;r++)
6        {
7            if(nums[r] == 0)
8                zerosCount++;
9            while(zerosCount > k)
10            {
11                if(nums[l] == 0)
12                    zerosCount--;
13                l++;
14            }
15            ans = Math.max(ans, r-l+1);
16        }
17
18    return ans;
19    }
20}