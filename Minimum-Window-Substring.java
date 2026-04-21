1class Solution {
2 public String minWindow(String s, String t)
3    {
4        int l = 0, r = 0;
5        int start = 0, length = Integer.MAX_VALUE;
6        int[] freqArrLC = new int[26];
7        int[] freqArrUC = new int[26];
8        int[] tarArrLC = new int[26];
9        int[] tarArrUC = new int[26];
10
11        for (int i = 0; i < 26; i++)
12        {
13            freqArrLC[i] = freqArrUC[i] = tarArrUC[i] = tarArrLC[i] = 0;
14        }
15
16        for (int i = 0; i < t.length(); i++)
17        {
18
19            if (Character.isLowerCase(t.charAt(i)))
20            {
21                tarArrLC[t.charAt(i) - 'a']++;
22            } else
23            {
24                tarArrUC[t.charAt(i) - 'A']++;
25            }
26        }
27
28
29        for (r = 0; r < s.length(); r++)
30        {
31            if(Character.isLowerCase(s.charAt(r)))
32            {
33                freqArrLC[s.charAt(r) - 'a']++;
34            }
35            else
36                freqArrUC[s.charAt(r) - 'A']++;
37
38
39            while(l <=  r  && isSuperSet(freqArrLC, freqArrUC, tarArrLC, tarArrUC))
40            {
41                if(length > r-l+1)
42                {
43                    start = l;
44                    length = r-l+1;
45                }
46                if(Character.isLowerCase(s.charAt(l)))
47                {
48                    freqArrLC[ s.charAt(l)- 'a']--;
49                }
50                else
51                {
52                    freqArrUC[ s.charAt(l)- 'A']--;
53                }
54                l++;
55            }
56
57
58        }
59
60
61
62
63        if(length == Integer.MAX_VALUE)
64            return "";
65        return s.substring(start, start+ length);
66
67    }
68    public boolean isSuperSet(int[] freqLC, int[] freqUC, int[] tarLC, int[] tarUC)
69    {
70
71        boolean valid = true;
72        for(int i=0;i<26;i++)
73        {
74            if(!(freqLC[i] >= tarLC[i] && freqUC[i] >= tarUC[i])){
75                valid = false;
76                break;
77            }
78
79        }
80        return valid;
81    }
82}