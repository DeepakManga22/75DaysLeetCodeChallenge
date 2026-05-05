class Solution {
    public int threeSumClosest(int[] nums, int tar) {
        Arrays.sort(nums);
        int cloSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int curSum=nums[i]+nums[l]+nums[r];
                if(Math.abs(tar-curSum)<Math.abs(tar-cloSum)){
                    cloSum=curSum;
                }
                if(curSum<tar){
                    l++;
                }else if(curSum>tar){
                    r--;
                }else{
                    return curSum;
                }
            }
        }
        return cloSum;
    }
}