1class Solution {
2public:
3    bool isValidSudoku(vector<vector<char>>& board) {
4        bool flag = true;
5        //rows
6        for(int i=0;i<9 && flag;i++)
7        {
8            unordered_set<char> row_set;
9            for(int j=0;j<9 && flag;j++)
10            {
11                if(board[i][j] != '.')
12                {
13                    if(row_set.find(board[i][j]) != row_set.end())
14                    {
15                        flag = false;
16                        break;
17                    }
18                    else
19                        row_set.insert(board[i][j]);
20                }
21            }
22
23        }
24
25        //columns
26
27        for(int i=0;i<9 && flag;i++)
28        {
29            unordered_set<char> col_set;
30            for(int j=0;j<9 && flag;j++)
31            {
32                if(board[j][i] != '.')
33                {
34                    if(col_set.find(board[j][i]) != col_set.end())
35                    {
36                        flag = false;
37                        break;
38                    }
39                    else
40                        col_set.insert(board[j][i]);
41                }
42            }
43            
44        }
45
46        //boxes
47        
48        for(int i=0;i<9 && flag;i+=3)
49        {
50            for(int q=0; q< 9 && flag; q+=3)
51            {
52                unordered_set<char> box_set;
53            
54                for(int k=i;k<i+3  && flag;k++ )
55                {
56
57                    for(int j=q;j<q+3 && flag;j++)
58                    {
59                        if(board[k][j] != '.')
60                        {
61                            if(box_set.find(board[k][j]) != box_set.end())
62                            {
63                                flag = false;
64                                break;
65                            }
66                            else
67                                box_set.insert(board[k][j]);
68                                
69                        }
70                    }
71                }
72            }
73        }
74        return flag;
75    }
76};