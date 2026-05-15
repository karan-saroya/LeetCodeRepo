1class Solution {
2public:
3    int minEatingSpeed(vector<int>& piles, int h) 
4    {
5        long minK =1, maxK = 1000000000;
6        int ans = 1000000000;
7        while(minK <= maxK)
8        {
9            if(minK == maxK)
10            {
11                if(isValid(minK, h, piles))
12                    return minK;
13                return ans;
14            }
15            else if(maxK- minK == 1)
16            {
17                if(isValid(minK, h, piles))
18                    return minK;
19                else
20                {
21                    if(isValid(maxK,h, piles))
22                        return maxK;
23                    return ans;
24                }
25            }
26
27            long mid = (minK+maxK)/2;
28            if(isValid(mid,h, piles))
29            {
30                if(mid< ans)
31                    ans = mid;
32
33                maxK=mid-1;
34            }
35            else
36            {
37                minK = mid+1;
38            }
39
40        }
41        return ans;
42        
43    }
44    bool isValid(int k, int h, vector<int>& piles)
45    {
46        long count= 0;
47        for(int i=0;i<piles.size();i++)
48        {
49            count+=piles[i]/k;
50            if(piles[i]%k != 0)
51                count++;
52        }
53        if(count <= h)
54            return true;
55        return false;
56    }
57
58
59};