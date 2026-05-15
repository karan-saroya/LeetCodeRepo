1class Solution {
2public:
3    int lastStoneWeight(vector<int>& stones) 
4    {
5        priority_queue<int> pq;
6        for(int i=0;i<stones.size();i++)
7        {
8            pq.push(stones[i]);
9        }
10        while(pq.size() > 1)
11        {
12                int first =pq.top();
13                pq.pop();
14                int sec = pq.top();
15                pq.pop();
16                if(first> sec)
17                    pq.push(first-sec);
18        }
19        if(pq.size() == 1)
20            return pq.top();
21        return 0;
22    }
23};