1class Solution {
2    public int minSubArrayLen(int target, int[] nums)
3    {
4        int ans = Integer.MAX_VALUE;
5        int l=0,r=0, currSum = 0;
6        for(r=0;r<nums.length;r++)
7        {
8            currSum += nums[r];
9            while(l <= r  && currSum >= target)
10            {
11                ans = Math.min(ans, r-l+1);
12                currSum -= nums[l];
13                l++;
14
15            }
16        }
17        ans  = (ans == Integer.MAX_VALUE ? 0 : ans);
18        return ans;
19
20    }
21}