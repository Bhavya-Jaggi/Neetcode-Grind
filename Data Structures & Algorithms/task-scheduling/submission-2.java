// import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // --- PHASE 1: GREEDY SETUP ---
        // We only care about task frequencies, not the tasks themselves.
        // We always want to process the most frequent tasks first to prevent 
        // them from bottlenecking us at the end with unavoidable cooldowns.
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }

        // The Max-Heap acts as our "Ready to Execute" pool.
        // It guarantees we always have immediate access to the task with the highest remaining frequency.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < 26 ; i++) {
            if(freq[i] > 0)
                maxHeap.offer(freq[i]);
        }

        // The Queue acts as our "Cooldown Waiting Room".
        // Stores: [remaining_frequency, time_it_can_be_executed_again]
        Queue<int[]> cooldownQueue = new LinkedList<>();
        int timer = 0;

        // --- PHASE 2: CPU SIMULATION ---
        // The CPU keeps running as long as there are tasks either ready to run OR cooling down.
        while(maxHeap.size() > 0 || cooldownQueue.size() > 0) {
            
            // 1. Tick the global clock. Every loop iteration represents 1 unit of CPU time (either working or idle).
            timer++;

            // 2. CPU Execution Block
            if(maxHeap.size() > 0) {
                int task = maxHeap.poll(); // Grab the most frequent available task
                task--;                    // Execute it (frequency drops by 1)
                
                // If the task still has instances left to run, it cannot go back to the heap yet.
                // It goes to the waiting room. It will be eligible to run again at current (timer) + required cooldown (n).
                if(task > 0) {
                    cooldownQueue.offer(new int[]{task , timer + n});
                }
            }

            // 3. Cooldown Resolution Block
            // Check the task at the front of the waiting room. 
            // Because it's a FIFO Queue, the front element is always the closest to finishing its cooldown.
            if(cooldownQueue.size() > 0 && cooldownQueue.peek()[1] == timer ) {
                // Cooldown is over! Extract its remaining frequency and put it back into the "Ready" pool.
                int[] temp = cooldownQueue.poll();
                maxHeap.offer(temp[0]);
            }
        }

        return timer; // Total CPU cycles simulated
    }
}