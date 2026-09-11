class Solution {
    public void dfs(int[][] grid,int[][] time,int i,int j,int t)
    {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j] ==0 || t>= time[i][j])
        {
            return ;
        }
        time[i][j]=t;
        dfs(grid,time,i-1,j,t+1);
        dfs(grid,time,i+1,j,t+1);
        dfs(grid,time,i,j-1,t+1);
        dfs(grid,time,i,j+1,t+1);
    }
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return -1;
       int m=grid.length;
       int n=grid[0].length;
       int[][] time = new int[m][n];
       for(int i=0;i<m;i++)
       {
            Arrays.fill(time[i],Integer.MAX_VALUE);
       }
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++){
            if(grid[i][j] ==2)
            {
                dfs(grid,time,i,j,0);
            }
        }
       }
       int timeReq=0;
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++)
        {
            if(grid[i][j] ==1){
            if(time[i][j] == Integer.MAX_VALUE) return -1;
            timeReq=Math.max(timeReq,time[i][j]);
            }
        }
     }
     return timeReq;
    }
}