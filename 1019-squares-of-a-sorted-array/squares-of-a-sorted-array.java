class Solution {
    public int[] sortedSquares(int[] nums) {
        int indexL=0, indexR=nums.length -1 ;
        int[] arr = new int[nums.length];
        int index = nums.length-1;
        while(indexL <= indexR)
        {

            //System.out.println("IdnexL: "+ indexL + " Index R:" + indexR);
            if((int)Math.pow(nums[indexL], 2) <= (int) Math.pow(nums[indexR], 2))
            {
                

                //System.out.println("Arr at index is :"+ (int)Math.pow(nums[indexR], 2) + " Index:" + index);
                arr[index--] = ((int)Math.pow(nums[indexR], 2));
                indexR--;
            }
            else
            {
               
                            //System.out.println("Arr at index is : "+ (int)Math.pow(nums[indexL], 2) + " Index:" + index);

                arr[index--] = (int)Math.pow(nums[indexL], 2);
                 indexL++;        
            }   
        }
        return arr;
    
    }
}