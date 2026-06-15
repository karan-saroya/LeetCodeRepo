1class Solution 
2{
3    int[][][][] dp;
4    public boolean isScramble(String s1, String s2) 
5   {
6        dp= new int[31][31][31][31];
7       for(int i=0;i<31;i++)
8       {
9	for(int j=0;j<31;j++)
10	{
11		for(int k=0;k<31;k++)
12		{
13			Arrays.fill(dp[i][j][k] , -1);
14		}
15	}
16       }
17	int state = canReach(0, s1.length()-1,0, s2.length()-1, s1, s2);
18	if(state == 1)
19		return true;
20	return false;
21       	
22    }
23   int canReach(int startS1, int endS1, int startS2, int endS2 , String s1, String s2)
24   {
25	if(startS1 == endS1)
26	{
27		if(s1.charAt(startS1) == s2.charAt(startS2))
28			return 1;
29		return 0;
30	}
31	// if(startS1 == endS1-1)
32	// {
33	// 	if(s1.charAt(startS1) == s2.charAt(startS2) && s1.charAt(endS1) == s2.charAt(endS2))
34	// 		return 1;
35	// 	return 0;
36
37	// }
38	if(dp[startS1][endS1][startS2][endS2]== -1)
39	{
40		int goodState =0;
41		for(int i=startS1;i<endS1;i++)
42		{
43			// 2 cases
44		int leftWoS = canReach(startS1,i, startS2, startS2+ i - startS1 +1,s1, s2);		
45		int rightWoS = canReach(i+1, endS1, startS2+i-startS1+1, endS2, s1,s2);
46        int WoS = leftWoS & rightWoS;
47
48		int leftWS = canReach(i+1,endS1, startS2, startS2+ endS1-i-1,s1, s2);		
49		int rightWS = canReach(startS1,i,startS2+endS1-i, endS2, s1,s2);
50		int WS = leftWS & rightWS;
51		int canReachString = WS | WoS;
52		if(canReachString ==  1)
53			goodState = 1;
54        }   
55		
56		dp[startS1][endS1][startS2][endS2]= goodState;
57	}
58	return dp[startS1][endS1][startS2][endS2];
59   }
60}
61