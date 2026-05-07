class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int indexL = 0, indexR = numbers.length-1;

        for(indexL=0;indexL< indexR;)
        {
            if(numbers[indexL] + numbers[indexR] > target)
                indexR--;
            else if(numbers[indexL] + numbers[indexR] < target)
                indexL++;
            else 
                break;

        }
        if(indexL == indexR)
            return new int[]{0,0}; 
        return new int[]{indexL+1, indexR+1};

    }
}