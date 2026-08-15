class Solution {
    public long fun(int[] piles,int mid,int n){
        long totalhours=0;
        for(int i=0;i <n;i++)
        {
            totalhours += (piles[i]+(long)mid-1 )/mid;
        }
        return totalhours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,piles[i]);
        }
        int low=1;
        int high=max;
        while(low <= high){
            int mid=low+(high-low)/2;
            long totalhours=fun(piles,mid,n);
            if(totalhours <= h)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}