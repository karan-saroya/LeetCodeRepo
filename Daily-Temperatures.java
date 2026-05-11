1class Solution {
2    public int[] dailyTemperatures(int[] temperatures) 
3    {
4        Deque<int[]> stack = new ArrayDeque<int[]>();
5        int[] ans = new int[temperatures.length];
6        Arrays.fill(ans, 0);
7        stack.push(new int[]{temperatures[0], 0});
8        for(int i= 1;i<temperatures.length;i++)
9        {
10            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i])
11            {
12                int[] ele =  stack.peek();
13                //System.out.println(ele[0] + " "+ ele[1]);
14                ans[ele[1]] = i - ele[1];
15                stack.pop();
16            }
17            stack.push(new int[]{temperatures[i], i});
18        }       
19        return ans;
20
21    }
22}