1class Solution {
2     public int lengthOfLongestSubstring(String s)
3    {
4        int l=0,r=0;
5        HashSet<Character> hasSeen = new HashSet<Character>();
6        int ans = 0;
7        for(r =0;r< s.length();r++)
8        {
9            if(!hasSeen.contains(s.charAt(r)))
10            {
11                hasSeen.add(s.charAt(r));
12                if(ans < r-l+1 )
13                {
14                    ans = r-l+1;
15                }
16
17            }
18            else {
19                while ( l < r  && s.charAt(l) != s.charAt(r))
20                {
21                    hasSeen.remove(s.charAt(l));
22                    l++;
23                }
24                if(s.charAt(l) == s.charAt(r) && l != r)
25                {
26                    l++;
27                    if(ans < r-l +1)
28                    {
29                        ans = r-l +1;
30                    }
31                }
32                else
33                {
34                    System.out.println("This should never happen");
35                }
36
37            }
38
39
40        }
41
42        return ans;
43
44    }
45}