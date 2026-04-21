1class Solution {
2    public int characterReplacement(String s, int k)
3    {
4
5        int maxFreq =0, l= 0, r= 0;
6        int[] count = new int[26];
7        int ans = 0;
8        for(int i=0;i<count.length;i++)
9            count[i] =0;
10
11        for(r=0;r<s.length();r++)
12        {
13            count[s.charAt(r) - 'A']++;
14            if(count[s.charAt(r) - 'A'] > maxFreq)
15                maxFreq =  count[s.charAt(r) - 'A'];
16
17            while(l <=r  && r- l + 1 - maxFreq> k)
18            {
19                maxFreq= 0;
20                count[ s.charAt(l) - 'A']--;
21
22                for(int i=0;i<26;i++)
23                {
24                    if(count[i] > maxFreq)
25                        maxFreq = count[i];
26                }
27                l++;
28            }
29            if(r-l +1 > ans)
30                ans = r-l+1;
31        }
32
33        return ans;
34
35
36    }
37}