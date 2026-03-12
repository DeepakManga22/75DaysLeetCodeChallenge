class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int target=sc.nextInt();
         Solution sol = new Solution();
        int[] ans = sol.twoSum(nums, target);
        
        if (ans.length == 2) {
            System.out.println("[" + ans[0] + ", " + ans[1] + "]");
        } else {
            System.out.println("No solution found.");
        }

        sc.close();
    }
}