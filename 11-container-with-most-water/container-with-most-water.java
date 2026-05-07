class Solution {
    public int maxArea(int[] height) {
         int indexR= height.length -1, indexL=0;
        int maxArea = -1;
        for(indexL= 0; indexL < indexR;)
        {
            if(Math.min(height[indexL], height[indexR]) * (indexR - indexL) > maxArea)
                maxArea = Math.min(height[indexL], height[indexR]) * (indexR - indexL);
            
            if(height[indexR] >= height[indexL])
                indexL++;
            else
                indexR--;
        }
        return maxArea;
    }
}