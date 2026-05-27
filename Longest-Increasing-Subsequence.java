1class Solution {
2    public int lengthOfLIS(int[] nums) 
3    {
4        List<Integer> endList  = new ArrayList<Integer>();
5        endList.add(nums[0]);
6        for(int i=1;i<nums.length;i++)
7        {
8            int index = Collections.binarySearch(endList, nums[i]);
9            if(index < 0)
10            {
11                index = -(index+1);
12            }
13            if(index == endList.size())
14            {
15                endList.add(nums[i]);
16            }
17            else
18            {
19                endList.set(index,nums[i]);
20            }
21        }
22        return endList.size();
23    }
24}