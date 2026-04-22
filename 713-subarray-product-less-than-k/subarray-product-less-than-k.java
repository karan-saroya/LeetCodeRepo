class Solution {
     public int numSubarrayProductLessThanK(int[] nums, int k)
    {
        int l = 0, r = 0, winProd = 1;
        int ans = 0;

        for (r = 0; r < nums.length; r++)
        {
            winProd *= nums[r];
            while(l <= r  && winProd >= k)
            {
                winProd = winProd / nums[l];
                l++;
            }
            if(r-l+1> 0)
                ans+= r-l+1;

        }

        return ans;
    }
}