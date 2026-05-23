import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stones to heap
        for (int stone : stones) {
            pq.add(stone);
        }

        // Smash stones until one or none left
        while (pq.size() > 1) {
            int y = pq.poll(); // heaviest
            int x = pq.poll(); // second heaviest

            // If not equal, add remaining weight
            if (y != x) {
                pq.add(y - x);
            }
        }

        // Return remaining stone or 0
        return pq.isEmpty() ? 0 : pq.poll();
    }
}