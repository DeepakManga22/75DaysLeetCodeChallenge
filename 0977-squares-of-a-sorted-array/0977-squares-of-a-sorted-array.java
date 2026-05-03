class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] re=new int[n];
        int l=0;
        int r=n-1;
        int index=n-1;
        while(l<=r){
            int leftSq=nums[l]*nums[l];
            int rigSq=nums[r]*nums[r];
            if(leftSq>rigSq){
                re[index]=leftSq;
                l++;
            }else{
                re[index]=rigSq;
                r--;
            }
            index--;
        }
        return re;
    }
}