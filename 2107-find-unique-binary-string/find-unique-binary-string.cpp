class Solution {
public:
    int stringToNum(string s)
    {
        int power = 1;
        int answ= 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s[i] != '0')
                answ+= power;
            power=power*2;
        }
        return answ;
    }
    string intToString(int i, int length)
    {
        int curr_length=0;
        string answer="";
        while(i>0)
        {
            answer= to_string(i%2)+ answer;
            i=i/2;
            curr_length++;
        }
        while(curr_length < length)
        {
            answer= "0"+ answer;
            curr_length++;
        }
        return answer;
    }
    string findDifferentBinaryString(vector<string>& nums) {
        unordered_set<int> doesExist;
        for(int i=0;i<nums.size();i++)
            doesExist.insert(stringToNum(nums[i]));
        
        string answer="";
        for(int i=0;i<pow(2,17)-1;i++)
        {
            if(doesExist.find(i) == doesExist.end())
            {
                answer =  intToString(i, nums[0].length());
                break;
            }
        

        }
            return answer;
    }
};