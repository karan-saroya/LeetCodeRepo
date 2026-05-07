class Solution {
    public int findDuplicate(int[] nums) 
    {
        int ans=0;
        int i=0;
        while(i < nums.length)
        {
            if(nums[i] -1 != i)
            {
                int temp = nums[nums[i] -1];
                if(nums[i] == temp)
                    {
                        ans = nums[i];
                        break;
                    }
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            if(nums[i] -1 == i)
            {
              i++;
            }
            
        }

        return ans;
    }
        

        
}
