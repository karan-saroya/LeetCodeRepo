1class Solution {
2        public int numberOfSubarrays(int[] nums, int k)
3    {
4
5        return atMost(nums, k) - atMost(nums, k-1);
6
7    }
8    public int atMost(int[] nums, int k)
9    {
10        int l=0,r=0, ans= 0, oddNumCount = 0;
11
12        for(r =0;r< nums.length;r++)
13        {
14            if(nums[r]%2 == 1)
15                oddNumCount++;
16
17            while(oddNumCount > k && l <= r)
18            {
19                if(nums[l]%2 == 1)
20                    oddNumCount--;
21                l++;
22            }
23
24            if(r-l+1 > 0)
25                ans+=r-l+1;
26
27
28        }
29        return ans;
30    }
31
32}