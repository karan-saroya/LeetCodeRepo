1class Solution {
2    public int lengthOfLongestSubstringKDistinct(String s, int k)
3    {
4        int l = 0, r = 0, ans = 0;
5        HashMap<Character, Integer> freqCount = new HashMap<>();
6        for (r = 0; r < s.length(); r++)
7        {
8            if (freqCount.containsKey(s.charAt(r)))
9            {
10                    freqCount.replace(s.charAt(r), freqCount.get(s.charAt(r)) + 1);
11            }
12            else
13            {
14                freqCount.put(s.charAt(r), 1);
15            }
16
17            while( freqCount.size() > k && l <= r)
18            {
19                char remove = s.charAt(l);
20                freqCount.replace(remove, freqCount.get(remove) - 1);
21                if(freqCount.get(remove) == 0)
22                    freqCount.remove(remove);
23                l++;
24            }
25
26            ans = Math.max(ans, r-l+1);
27
28        }
29        return ans;
30
31    }
32}