class Solution {
    public int fun(int[] nums,int mid,int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=(nums[i]+mid-1)/mid;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int low=1;
        int high=max;
        int ans=0;
        while(low <= high)
        {
            int mid=low+(high-low)/2;
            int func=fun(nums,mid,n);
            if(func <= threshold)
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