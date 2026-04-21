class Solution {
    public int minSubArrayLen(int target, int[] nums)
    {
        int ans = Integer.MAX_VALUE;
        int l=0,r=0, currSum = 0;
        for(r=0;r<nums.length;r++)
        {
            currSum += nums[r];
            while(l <= r  && currSum >= target)
            {
                ans = Math.min(ans, r-l+1);
                currSum -= nums[l];
                l++;

            }
        }
        ans  = (ans == Integer.MAX_VALUE ? 0 : ans);
        return ans;

    }
}