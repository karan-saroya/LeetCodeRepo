class Solution {
      public int longestOnes(int[] nums, int k)
    {
        int l=0, r=0, zerosCount = 0, ans =0;
        for(r=0; r< nums.length;r++)
        {
            if(nums[r] == 0)
                zerosCount++;
            while(zerosCount > k)
            {
                if(nums[l] == 0)
                    zerosCount--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }

    return ans;
    }
}