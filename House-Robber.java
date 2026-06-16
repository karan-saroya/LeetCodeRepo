1class Solution
2{
3	int[] val;
4	public int rob(int[] nums)
5	{
6		val = new int[nums.length];
7		Arrays.fill(val, -1);
8		return maxCost(0, nums);
9	}
10	int maxCost(int index,int[] nums)
11	{
12		if(index >= nums.length)
13			return 0;
14		if(val[index]== -1)
15		{
16			val[index] = Math.max( nums[index] + maxCost(index+2, nums), maxCost(index+1, nums));
17		}
18		return val[index];
19	}
20}
21