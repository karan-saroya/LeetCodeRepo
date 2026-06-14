1public class Solution
2{
3int[][] dp;
4    public int maxCoins(int[] nums) 
5    {
6    dp = new int[nums.length][nums.length];       
7    for(int i=0;i<nums.length;i++)
8    {
9        Arrays.fill(dp[i], Integer.MIN_VALUE);
10    }
11    return maxBaloonsValue(0, nums.length-1, nums);
12    }
13int maxBaloonsValue(int start, int end, int[] nums)
14{
15	if(start==end)
16	{
17		int left=1;
18 		int right=1;
19		if(start-1 >= 0)
20    left=nums[start-1];
21    if(end+1< nums.length)
22        right=nums[end+1];
23    return left*right*nums[start];	
24        }
25        
26    if(dp[start][end] == Integer.MIN_VALUE)
27    {
28        int maxProductSum =0;
29        for(int i=start;i<=end;i++)
30        {
31            // this could be the last index to be popped
32            
33            int maxLeftProdSum = 0;
34            int maxRightProdSum= 0;
35            if(i - 1>= start )
36                maxLeftProdSum = maxBaloonsValue(start, i-1, nums);
37            if(i+1 <= end)
38                maxRightProdSum = maxBaloonsValue(i+1, end, nums);
39
40            int productSum = neighborProduct(i, start, end, nums) + maxLeftProdSum + maxRightProdSum ;
41            if(maxProductSum < productSum)
42            {
43                maxProductSum = productSum;
44            }
45
46        }
47        dp[start][end] = maxProductSum;
48
49    }
50    return dp[start][end];
51        
52    }
53    int neighborProduct(int currIndex, int start , int end, int[] nums)
54    {
55        int maxProd =nums[currIndex];
56        if(start !=0 )
57        {
58            maxProd = maxProd*nums[start-1];
59        }
60        if(end != nums.length-1)
61        {
62            maxProd *=nums[end+1];
63        }
64        return maxProd;
65    }
66	
67}
68