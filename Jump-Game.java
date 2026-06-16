1class Solution
2{
3	int[] canReach;
4	public boolean canJump(int[] nums) 
5{
6        		canReach = new int[nums.length];
7		Arrays.fill(canReach, -1);
8		int answer  =reach(0, nums);
9		if(answer == 1)
10			return true;
11		return false;
12    	}
13	int reach(int index, int[] nums)
14	{
15		if(index ==  nums.length-1)
16            return 1;
17        if(index >= nums.length)
18            return 0;
19		if(canReach[index] == -1)
20		{
21            int reachable= 0;
22            for(int i= index+1;i <= Math.min(nums.length-1, index+nums[index]) ;i++)
23            {
24                reachable = reachable | reach(i, nums);
25            } 
26            canReach[index] = reachable;
27        }
28        return canReach[index];	
29	}
30
31}
32