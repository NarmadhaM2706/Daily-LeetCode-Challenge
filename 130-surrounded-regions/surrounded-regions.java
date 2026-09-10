class Solution {
    
    public void dfs(char[][] grid,int i,int j )
    {
        if(i<0 || j<0 || i==grid.length || j== grid[0].length||grid[i][j] != 'O' )
        {
            return;
        }
        grid[i][j]='2';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
    public void solve(char[][] grid)
    {
        int m=grid.length;
        int  n=grid[0].length;
        for(int i=0;i<m;i++)
        {
        
           if(grid[i][0]=='O')
           {
            dfs(grid,i,0);
           }
            if(grid[i][n-1]=='O')
            {
                dfs(grid,i,n-1);
            }

        }
        for(int j=0;j<n;j++)
        {
            if(grid[0][j] == 'O')
            {
                dfs(grid,0,j);
            }
            if(grid[m-1][j]=='O')
            {
                dfs(grid,m-1,j);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '2')
                {
                    grid[i][j]='O';
                }
                else if(grid[i][j]== 'O')
                {
                    grid[i][j]='X';
                }
            }
        }
    
    }
}