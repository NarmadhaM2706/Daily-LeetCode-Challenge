class Solution {
    public void dfs(char[][] grid,int i,int j,Boolean[][] vis)
    {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]=='0' ||vis[i][j]==true)
        {
            return;
        }
        vis[i][j]=true;
        dfs(grid,i,j-1,vis);
        dfs(grid,i,j+1,vis);
        dfs(grid,i-1,j,vis);
        dfs(grid,i+1,j,vis);
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Boolean[][] vis= new Boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                vis[i][j]=false;
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1' && vis[i][j] == false)
                {
                    cnt++;
                    dfs(grid,i,j,vis);
                }
            }
        }
        return cnt;
    }
}