class Solution {
    public boolean searchMatrix(int[][] matrix, int tar) {
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0;
        int r=m*n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int row=mid/n;
            int col=mid%n;
            int value=matrix[row][col];
            if(value==tar){
                return true;
            }
            else if(value<tar){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }
}