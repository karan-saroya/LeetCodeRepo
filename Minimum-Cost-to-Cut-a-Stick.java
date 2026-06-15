1public class Solution
2{
3	Map<Integer, Map<Integer, Integer>> dp;
4	 public int minCost(int n, int[] cuts) 
5    {
6        dp = new HashMap<Integer, Map<Integer, Integer>>();
7		Arrays.sort(cuts);
8		return mc(0, n,cuts);
9    }
10	int mc(int start, int end, int[] cuts)
11	{
12		if(start == end-1)
13		{
14			return 0;
15        }
16
17			
18		if(!stateExists(start, end))
19		{
20			int currCutVal = end - start;
21			int minCutsVal =Integer.MAX_VALUE;
22			
23			for(int i=0;i<cuts.length;i++)
24			{
25				if(cuts[i] >= end)
26					break;
27				if(cuts[i] > start)
28				{
29					int leftCut = mc(start, cuts[i], cuts);
30					int rightCut = mc(cuts[i], end, cuts);
31					if(leftCut + rightCut < minCutsVal)
32						minCutsVal= leftCut+ rightCut;
33				}
34	
35			}
36			if(minCutsVal == Integer.MAX_VALUE)
37                {
38                    insertVal(start, end, 0);
39                }
40            else	
41				insertVal(start, end, minCutsVal+ currCutVal);
42		}
43		return dp.get(start).get(end);
44
45	}
46    boolean stateExists(int start, int end)
47    {
48            if(dp.containsKey(start) && dp.get(start).containsKey(end))
49                return true;
50            return false;
51    }
52    void insertVal(int start, int end, int val)
53    {
54            if(dp.containsKey(start))
55            {
56                Map<Integer, Integer>  startMap = dp.get(start);
57                startMap.put(end, val);
58            }
59            else
60            {
61                Map<Integer, Integer>  startMap = new HashMap<Integer, Integer>();
62                startMap.put(end, val);
63                dp.put(start, startMap);
64            }
65    }
66	
67}
68