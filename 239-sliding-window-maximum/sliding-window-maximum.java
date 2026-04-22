class Solution {
    class Pair
{
    Integer number;
    Integer index;

    Pair(int number, int index)
    {
        this.number = number;
        this.index = index;
    }
    public String toString()
    {
        return "Number: "+ number + " Index: "+ index;
    }
};
     public int[] maxSlidingWindow(int[] nums, int k)
    {
        Deque<Pair> deque = new ArrayDeque<Pair>();
        int[] ans = new int[nums.length - k + 1];
        for(int r=0;r<k;r++)
        {
            while( !deque.isEmpty() && nums[r] > deque.peekLast().number)
            {
                deque.pollLast();
            }
            deque.offerLast(new Pair(nums[r], r));
        }
        //System.out.println(deque);
        ans[0]= deque.peekFirst().number;
        int startIndex = 0;
        for(int r=k;r< nums.length;r++)
        {

            while( !deque.isEmpty() && nums[r] > deque.peekLast().number)
            {
                deque.pollLast();
            }

            deque.offerLast(new Pair(nums[r], r));

            while(deque.peekFirst().index <= startIndex)
            {
                deque.pollFirst();
            }
            startIndex++;
            ans[r-k+1] = deque.peekFirst().number;

           // System.out.println(deque);
        }


        return ans;

    }
}
