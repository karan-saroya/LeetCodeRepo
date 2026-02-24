1class Solution {
2public:
3    vector<int> twoSum(vector<int>& numbers, int target)
4    {
5        int start=0, end=numbers.size()-1;
6        vector<int> answer={};
7        while(start < end)
8        {
9            if(numbers[start] + numbers[end] == target)
10            {
11                answer.push_back(start+1);
12                answer.push_back(end+1);
13                break;
14            }
15            else if (numbers[start] + numbers[end] > target)
16            {
17                end--;
18                continue;
19            }
20            else
21            {
22                start++;
23                continue;
24            }
25        }
26        return answer;
27    }
28    
29};