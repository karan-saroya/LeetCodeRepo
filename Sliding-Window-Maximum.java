1class Solution {
2    class Pair
3{
4    Integer number;
5    Integer index;
6
7    Pair(int number, int index)
8    {
9        this.number = number;
10        this.index = index;
11    }
12    public String toString()
13    {
14        return "Number: "+ number + " Index: "+ index;
15    }
16};
17     public int[] maxSlidingWindow(int[] nums, int k)
18    {
19        Deque<Pair> deque = new ArrayDeque<Pair>();
20        int[] ans = new int[nums.length - k + 1];
21        for(int r=0;r<k;r++)
22        {
23            while( !deque.isEmpty() && nums[r] > deque.peekLast().number)
24            {
25                deque.pollLast();
26            }
27            deque.offerLast(new Pair(nums[r], r));
28        }
29        //System.out.println(deque);
30        ans[0]= deque.peekFirst().number;
31        int startIndex = 0;
32        for(int r=k;r< nums.length;r++)
33        {
34
35            while( !deque.isEmpty() && nums[r] > deque.peekLast().number)
36            {
37                deque.pollLast();
38            }
39
40            deque.offerLast(new Pair(nums[r], r));
41
42            while(deque.peekFirst().index <= startIndex)
43            {
44                deque.pollFirst();
45            }
46            startIndex++;
47            ans[r-k+1] = deque.peekFirst().number;
48
49           // System.out.println(deque);
50        }
51
52
53        return ans;
54
55    }
56}
57