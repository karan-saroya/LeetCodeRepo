class Solution {
public int longestOnes(int[] nums, int k)
    {
        int l=0, r=0, zerosCount = 0, ans =0;
        for(r = 0;r < nums.length ; r++)
        {
            if (nums[r] == 0)
            {
                if(zerosCount >= k)
                {
                    while( l < r && zerosCount >= k )
                    {
                        if(nums[l] == 0)
                            zerosCount--;
                        l++;
                    }
                    if(l == r && zerosCount > k-1)
                    {
                        zerosCount =0;
                        l++;
                    }
                    else if(l == r && zerosCount == k-1)
                    {
                        zerosCount++;

                    }
                    else if(zerosCount == k-1)
                    {
                        zerosCount++;
                        
                    }

                }
                else
                {
                    zerosCount++;
                    ans = Math.max(r-l+1, ans);
                }
            }
            else
            {
                ans = Math.max(r-l+1, ans);
            }
        }

    return ans;
    }
}