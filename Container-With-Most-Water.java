1class Solution {
2    public int maxArea(int[] height) {
3         int indexR= height.length -1, indexL=0;
4        int maxArea = -1;
5        for(indexL= 0; indexL < indexR;)
6        {
7            if(Math.min(height[indexL], height[indexR]) * (indexR - indexL) > maxArea)
8                maxArea = Math.min(height[indexL], height[indexR]) * (indexR - indexL);
9            
10            if(height[indexR] >= height[indexL])
11                indexL++;
12            else
13                indexR--;
14        }
15        return maxArea;
16    }
17}