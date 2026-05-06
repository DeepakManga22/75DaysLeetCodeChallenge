class Solution {
    public int minSubArrayLen(int tar, int[] nums) {
        int l=0;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=tar){
                minLen=Math.min(minLen,r-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}