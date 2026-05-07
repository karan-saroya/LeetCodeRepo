1class Solution {
2    public int trap(int[] height) {
3        int[] leftMax= new int[height.length];
4        int[] rightMax= new int[height.length];
5        int currLeftMax = -1, currRightMax = -1;
6
7        for(int i=0;i<height.length;i++)
8        {
9            leftMax[i] = currLeftMax;
10            if(currLeftMax < height[i])
11            {
12                currLeftMax = height[i];
13            }
14        }
15        for(int i=height.length -1 ; i>=0 ;i--)
16        {
17            rightMax[i] = currRightMax;
18            if(currRightMax < height[i])
19            {
20                currRightMax = height[i];
21            }
22        }
23        int ans=0;
24        for(int i=0;i< height.length;i++)
25        {
26            if(Math.min(rightMax[i], leftMax[i]) > height[i] )
27            {
28                ans += Math.min(rightMax[i], leftMax[i]) - height[i];
29            }
30
31        }
32        return ans;
33    }
34}