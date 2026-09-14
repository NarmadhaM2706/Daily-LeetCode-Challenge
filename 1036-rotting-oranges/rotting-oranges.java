class Solution {
    public void dfs(int[][] grid,int[][] time,int i,int j,int count){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j] == 0  || count >= time[i][j] )
        {
            return;
        }
        time[i][j] =count;
        dfs(grid,time,i-1,j,count+1);
        dfs(grid,time,i+1,j,count+1);
        dfs(grid,time,i,j-1,count+1);
        dfs(grid,time,i,j+1,count+1);

    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] time=new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2)
                {
                    dfs(grid,time,i,j,0);
                }
            }
        }
        int timeReq=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1)
                {
                    if(time[i][j] == Integer.MAX_VALUE)
                       return -1;
                    else
                        timeReq=Math.max(time[i][j],timeReq);
                }
            }
        }
        return timeReq;
    }
}