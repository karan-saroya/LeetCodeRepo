1class Solution {
2    public int findDuplicate(int[] nums) 
3    {
4        int ans=0;
5        int i=0;
6        while(i < nums.length)
7        {
8            if(nums[i] -1 != i)
9            {
10                int temp = nums[nums[i] -1];
11                if(nums[i] == temp)
12                    {
13                        ans = nums[i];
14                        break;
15                    }
16                nums[nums[i] - 1] = nums[i];
17                nums[i] = temp;
18            }
19            if(nums[i] -1 == i)
20            {
21              i++;
22            }
23            
24        }
25
26        return ans;
27    }
28        
29
30        
31}
32