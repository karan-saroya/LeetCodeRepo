class Solution {
        public int numberOfSubarrays(int[] nums, int k)
    {

        return atMost(nums, k) - atMost(nums, k-1);

    }
    public int atMost(int[] nums, int k)
    {
        int l=0,r=0, ans= 0, oddNumCount = 0;

        for(r =0;r< nums.length;r++)
        {
            if(nums[r]%2 == 1)
                oddNumCount++;

            while(oddNumCount > k && l <= r)
            {
                if(nums[l]%2 == 1)
                    oddNumCount--;
                l++;
            }

            if(r-l+1 > 0)
                ans+=r-l+1;


        }
        return ans;
    }

}