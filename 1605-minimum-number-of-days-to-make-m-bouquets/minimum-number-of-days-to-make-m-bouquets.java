class Solution {
    public boolean possible(int[] bloomDay,int day,int m,int k)
    {
        int n=bloomDay.length;
        int cnt=0;
        int NoOfBouquets=0;
        for(int i=0;i<n;i++)
        {
            if(bloomDay[i] <= day)
            {
                cnt++;
            }
            else
            {
                NoOfBouquets += (cnt/k);
                cnt=0;
            }
        }
        NoOfBouquets += (cnt/k);
        if(NoOfBouquets >= m)
           return true;
        else
           return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,bloomDay[i]);
            min=Math.min(min,bloomDay[i]);
        }
        int low=min;
        int high=max;
        int ans=n;
        if((long)m*k > n) return -1;
        while(low <= high)
        {
            int mid=low+(high-low)/2;
            boolean fun=possible(bloomDay,mid,m,k);
            if(fun==true)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}