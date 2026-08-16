class Solution {
    public int fun(int[] weights,int capacity,int n)
    {
        int days=1;
        int load=0;;
        for(int i=0;i<n;i++){
            if(load+weights[i] > capacity){
                days+=1;
                load=weights[i];
            }
            else
            {
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int low=max;
        int high=sum;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int func=fun(weights,mid,n);
            if(func <= days)
            {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return  ans;
    }
}