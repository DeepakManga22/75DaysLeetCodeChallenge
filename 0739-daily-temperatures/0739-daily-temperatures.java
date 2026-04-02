class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&temp[i]>temp[stack.peek()]){
                int prevIn=stack.pop();
                ans[prevIn]=i-prevIn;
            }
            stack.push(i);
        }
        return ans;
    }
}