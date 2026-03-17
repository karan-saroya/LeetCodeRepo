class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
     
     // impolement n times 2 sum!i++
     sort(nums.begin(), nums.end());
     set<string> sols;
    for(int i=0;i<nums.size();i++)
    {
        cout<<"I: "<<i<<endl;
        
        int to_skip = i;
        int tar = 0 - nums[i];
        //cout<<"tar is:"<<tar<<endl;
        int start = 0, end = nums.size() -1;
        //cout<<"start "<<start<<" End:"<<end<<endl;
        while(start < end)
        {
            if(start == i)
            {
                start++;
              //  cout<<"start "<<start<<" Skipped pos"<<endl;
                continue;
            }
            else if(end == i)
            {
                end--;
              //  cout<<"end "<<end<<" Skipped pos"<<endl;
                continue;
            }
            if(nums[start] + nums[end] > tar)
            {
                end--;
             //    cout<<"end "<<end<<" decremented"<<endl;
            }
            else if(nums[start] + nums[end] < tar)
            {
                start++;
             //    cout<<"start "<<start<<" Incremented"<<endl;
            }
            else
            {
               // cout<<"Start" <<start<< " End "<<end<<endl;
                    vector<int> sol;
                    sol.push_back(nums[start]);
                    sol.push_back(nums[end]);
                    sol.push_back(nums[i]);
                    sort(sol.begin(), sol.end());
                    int lowest = sol[0];
                    int middle = sol[1];
                    int largest = sol[2];
                    sols.insert(to_string(lowest)+","+to_string(middle)+","+to_string(largest));
                    //cout<<"Added to sols"<< to_string(lowest)+","+to_string(middle)+","+to_string(largest)<<endl;
                    start++;
                    end--;
                while(start < end && nums[start] == nums[start-1])
                {
                    start++;

                }
                while(end> start && nums[end+1] == nums[end])
                    end--;
            }
            //cout<<"Cases end"<<endl;
            //<<"Start: "<< start<<"End "<<end<< endl;


        }

    }
    vector<vector<int>> ans;
    for(string str: sols)
    {
        stringstream ss(str);
        string token;

            vector<int> temp;
            
        while(getline(ss, token, ','))
        {
            temp.push_back(stoi(token));
        }
        ans.push_back(temp);
    }

    return ans;
    }
};