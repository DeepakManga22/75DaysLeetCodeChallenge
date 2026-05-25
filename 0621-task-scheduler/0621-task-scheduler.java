class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        
        // Count frequency of each task
        for(char task : tasks){
            freq[task - 'A']++;
        }
        
        // Find maximum frequency
        int maxFreq = 0;
        for(int f : freq){
            maxFreq = Math.max(maxFreq, f);
        }
        
        // Count how many tasks have maximum frequency
        int maxCount = 0;
        for(int f : freq){
            if(f == maxFreq){
                maxCount++;
            }
        }
        
        // Formula
        int intervals = (maxFreq - 1) * (n + 1) + maxCount;
        
        // Result is maximum of total tasks and calculated intervals
        return Math.max(tasks.length, intervals);
    }
}