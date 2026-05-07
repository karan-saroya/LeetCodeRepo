class Solution {
    public int trap(int[] height) {
        int[] leftMax= new int[height.length];
        int[] rightMax= new int[height.length];
        int currLeftMax = -1, currRightMax = -1;

        for(int i=0;i<height.length;i++)
        {
            leftMax[i] = currLeftMax;
            if(currLeftMax < height[i])
            {
                currLeftMax = height[i];
            }
        }
        for(int i=height.length -1 ; i>=0 ;i--)
        {
            rightMax[i] = currRightMax;
            if(currRightMax < height[i])
            {
                currRightMax = height[i];
            }
        }
        int ans=0;
        for(int i=0;i< height.length;i++)
        {
            if(Math.min(rightMax[i], leftMax[i]) > height[i] )
            {
                ans += Math.min(rightMax[i], leftMax[i]) - height[i];
            }

        }
        return ans;
    }
}