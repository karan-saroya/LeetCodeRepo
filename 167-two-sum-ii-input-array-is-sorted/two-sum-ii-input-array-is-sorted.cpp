class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target)
    {
        int start=0, end=numbers.size()-1;
        vector<int> answer={};
        while(start < end)
        {
            if(numbers[start] + numbers[end] == target)
            {
                answer.push_back(start+1);
                answer.push_back(end+1);
                break;
            }
            else if (numbers[start] + numbers[end] > target)
            {
                end--;
                continue;
            }
            else
            {
                start++;
                continue;
            }
        }
        return answer;
    }
    
};