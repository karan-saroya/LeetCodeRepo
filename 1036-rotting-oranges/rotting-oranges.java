class Solution {
    boolean[][] visited;
    int [][] dist;
    int max = 0;
    public int orangesRotting(int[][] grid) 
    {
        visited = new boolean[grid.length][grid[0].length];
        dist = new int[grid.length][grid[0].length];
        List<List<Integer>> currList = new ArrayList<List<Integer>>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                dist[i][j]= Integer.MAX_VALUE;

            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 2)
                {
                    List<Integer> coord = new ArrayList<Integer>();
                    coord.add(i);
                    coord.add(j);
                    currList.add(coord);
                    visited[i][j] = true;
                    dist[i][j] =0;
                }

            }
        }
                //System.out.println(currList);

        while(!currList.isEmpty())
        {
            List<List<Integer>> child = new ArrayList<List<Integer>>();
            while(!currList.isEmpty())
            {
                List<Integer> ord = currList.removeFirst();
                if(ord.get(0) +1 < grid.length && !visited[ord.get(0) +1][ord.get(1)])
                {
                    if(grid[ord.get(0) + 1][ ord.get(1)] == 0 )
                    {
                        
                    }
                    else if(grid[ord.get(0) + 1][ ord.get(1)] == 1)
                    {
                            visited[ord.get(0) + 1][ord.get(1)] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0) + 1);
                            coord.add(ord.get(1));
                            child.add(coord);
                            dist[ord.get(0) + 1][ord.get(1)] = dist[ord.get(0)][ord.get(1)] + 1;
                            
                            
                    }
                    else if(grid[ord.get(0) + 1][ ord.get(1)] == 2)
                    {
                            visited[ord.get(0) + 1][ord.get(1)] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0) + 1);
                            coord.add(ord.get(1));
                            child.add(coord);
                            

                    }
                }

                if(ord.get(0) -1 >= 0&& !visited[ord.get(0) -1][ord.get(1)])
                {
                    if(grid[ord.get(0) -1][ ord.get(1)] == 0 )
                    {
                        
                    }
                    else if(grid[ord.get(0) -1][ ord.get(1)] == 1)
                    {
                         visited[ord.get(0) -1][ord.get(1)] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0) -1);
                            coord.add(ord.get(1));
                            child.add(coord);
                            dist[ord.get(0) -1][ord.get(1) ] = dist[ord.get(0)][ord.get(1)] + 1;
                            
                            
                    }
                    else if(grid[ord.get(0) -1][ ord.get(1)] == 2)
                    {
                        visited[ord.get(0) -1][ord.get(1)] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0) -1);
                            coord.add(ord.get(1));
                            child.add(coord);
                            
                        
                    }
                }

                if(ord.get(1) -1 >= 0&& !visited[ord.get(0)][ord.get(1) -1])
                {
                    if(grid[ord.get(0)][ ord.get(1) -1] == 0 )
                    {
                        
                    }
                    else if(grid[ord.get(0)][ ord.get(1) -1] == 1)
                    {
                            visited[ord.get(0)][ord.get(1) -1] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0));
                            coord.add(ord.get(1) -1);
                            child.add(coord);
                            dist[ord.get(0) ][ord.get(1) -1] = dist[ord.get(0)][ord.get(1)] + 1;

                            
                    }
                    else if(grid[ord.get(0)][ ord.get(1) -1] == 2)
                    {   
                            visited[ord.get(0)][ord.get(1) -1] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0));
                            coord.add(ord.get(1) -1);
                            child.add(coord);
                            
                    }
                }


                  if(ord.get(1) +1 < grid[0].length && !visited[ord.get(0)][ord.get(1) +1])
                {
                    if(grid[ord.get(0)][ ord.get(1) +1] == 0 )
                    {
                        
                    }
                    else if(grid[ord.get(0)][ ord.get(1) +1] == 1)
                    {
                            visited[ord.get(0)][ord.get(1) +1] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0));
                            coord.add(ord.get(1) +1);
                            child.add(coord);
                            dist[ord.get(0) ][ord.get(1) +1] = dist[ord.get(0)][ord.get(1)] + 1;

                          
                    }
                    else if(grid[ord.get(0)][ ord.get(1) +1] == 2)
                    {
                            visited[ord.get(0)][ord.get(1) +1] = true;
                            List<Integer> coord = new ArrayList<Integer>();
                            coord.add(ord.get(0));
                            coord.add(ord.get(1) +1);
                            child.add(coord);
                           
                    }
                }
            }
//System.out.println(currList);

            currList.addAll(child);

                    //System.out.println(currList);
                   // System.out.println("Reset");

        }
    boolean freshAvail = false;
     for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1 && dist[i][j] == Integer.MAX_VALUE)
                {
                    freshAvail = true;
                    max = -1;
                    break;
                }
                else if(grid[i][j] == 1)
                {
                    if(dist[i][j] > max)
                        max = dist[i][j];

                }

            }
            if(freshAvail)
                break;
        }

    return max;
        
    }
}