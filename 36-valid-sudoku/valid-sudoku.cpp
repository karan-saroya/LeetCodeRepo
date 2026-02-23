class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        bool flag = true;
        //rows
        for(int i=0;i<9 && flag;i++)
        {
            unordered_set<char> row_set;
            for(int j=0;j<9 && flag;j++)
            {
                if(board[i][j] != '.')
                {
                    if(row_set.find(board[i][j]) != row_set.end())
                    {
                        flag = false;
                        break;
                    }
                    else
                        row_set.insert(board[i][j]);
                }
            }

        }

        //columns

        for(int i=0;i<9 && flag;i++)
        {
            unordered_set<char> col_set;
            for(int j=0;j<9 && flag;j++)
            {
                if(board[j][i] != '.')
                {
                    if(col_set.find(board[j][i]) != col_set.end())
                    {
                        flag = false;
                        break;
                    }
                    else
                        col_set.insert(board[j][i]);
                }
            }
            
        }

        //boxes
        
        for(int i=0;i<9 && flag;i+=3)
        {
            for(int q=0; q< 9 && flag; q+=3)
            {
                unordered_set<char> box_set;
            
                for(int k=i;k<i+3  && flag;k++ )
                {

                    for(int j=q;j<q+3 && flag;j++)
                    {
                        if(board[k][j] != '.')
                        {
                            if(box_set.find(board[k][j]) != box_set.end())
                            {
                                flag = false;
                                break;
                            }
                            else
                                box_set.insert(board[k][j]);
                                
                        }
                    }
                }
            }
        }
        return flag;
    }
};