1class Solution {
2   public int totalFruit(int[] fruits)
3    {
4        int l = 0, r = 0, ans = 0;
5        HashMap<Integer, Integer> count = new HashMap<>();
6        for ( r = 0; r < fruits.length; r++)
7        {
8            if(count.containsKey(fruits[r])){
9                count.replace(fruits[r], count.get(fruits[r]) + 1);
10            }
11            else
12                count.put(fruits[r], 1);
13
14            //System.out.println(count.values().stream().toList());
15                
16            while(l < r && count.size() > 2)
17            {
18                //System.out.println("L: "+ l + "  R:" + r);
19                count.replace(fruits[l], count.get(fruits[l])-1);
20                //System.out.println(count.values().stream().toList());
21                //System.out.println(fruits[l]);
22                if(count.get(fruits[l]) == 0)
23                    count.remove(fruits[l]);
24                l++;
25            }
26            ans = Math.max(ans, r-l+1);
27        }
28        return ans;
29
30    }
31}