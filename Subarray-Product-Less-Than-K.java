1class Solution {
2     public int numSubarrayProductLessThanK(int[] nums, int k)
3    {
4        int l = 0, r = 0, winProd = 1;
5        int ans = 0;
6
7        for (r = 0; r < nums.length; r++)
8        {
9            winProd *= nums[r];
10            while(l <= r  && winProd >= k)
11            {
12                winProd = winProd / nums[l];
13                l++;
14            }
15            if(r-l+1> 0)
16                ans+= r-l+1;
17
18        }
19
20        return ans;
21    }
22}