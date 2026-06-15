1
2class Solution {
3    int[][] isPalin;
4    int[] mc;    
5    public int minCut(String s) 
6    {
7	isPalin = new int[s.length()][s.length()];
8	mc = new int[s.length()];
9	for(int i=0;i<s.length();i++)
10	{
11		Arrays.fill(isPalin[i], -1);
12	}
13	Arrays.fill(mc, -1);
14	//O(n^2) - complexity time, space -> O(n^2)
15	for(int i=0;i<s.length();i++)
16	{
17		for(int j=i;j<s.length();j++)
18		{
19			if(isPalin[i][j] == -1)
20			isPalindrome(i,j,s);
21	}
22}
23
24return minCutPalindrome(0, s);
25
26	
27     }
28int isPalindrome(int start, int end, String s)
29{
30	if(start == end)
31	{
32		if(isPalin[start][end] == -1)
33			isPalin[start][end]=1;
34		
35	}
36	
37	if(start == end-1)
38	{
39		if(s.charAt(start) == s.charAt(end))
40		{
41			isPalin[start][end] = 1;
42}
43else
44			isPalin[start][end] = 0;
45	}
46	if(isPalin[start][end] == -1)
47	{
48		if(s.charAt(start) == s.charAt(end))
49	{
50		isPalin[start][end] = isPalindrome(start+1, end-1,s );
51	}
52	else
53		isPalin[start][end] = 0;
54}
55return isPalin[start][end];
56}
57int minCutPalindrome(int index, String s)
58{
59if(index >= s.length())
60return 0;	
61	if(isPalin[index][s.length()-1] == 1)
62		return 0;
63	int minCut=2001;
64if(mc[index] == -1)
65{
66
67
68
69	for(int i=index;i < s.length()-1;i++)
70	{
71		if(isPalin[index][i] == 1)
72		{
73			int numRightCuts = minCutPalindrome(i+1, s);
74			if(minCut> 1+ numRightCuts)
75			{
76				minCut = 1+ numRightCuts;
77			}
78		}
79
80	}
81	mc[index] = minCut;
82}
83return mc[index];
84}
85
86}
87