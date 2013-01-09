/*
 * Solution to the Task Scheduling Challenge.
 *
 * Approach: In each timestep, greedily schedule the 
 * task with the maximum possible current overshoot 
 * (may be negative). Optimize by peeking at the
 * second-highest priority task and 'jumping'
 * timesteps and assigning the prevailing task for
 * the jumped steps, as appropriate.
 *
 * @author Sanjay Paul
 * @date 12.25.2012
*/

import java.util.*;
import java.io.*;

class Solution {
    class Task implements Comparable {
        int id;
        int deadline;
        int time_left;
        
        public Task(int id, int deadline, int time_left) {
            this.id = id;
            this.deadline = deadline;
            this.time_left = time_left;
        }
        
        int compareTo(Task t2) {
            int base = Math.min(t2.deadline,deadline);
            int overshoot = base - deadline + time_left;
            int overshoot2 = base - t2.deadline + t2.time_left;
            if (overshoot < overshoot2)
                return -1;
            if (overshoot == overshoot2)
                return 0;
            return 1;
        }
    }
    
    public static void main(String args[]) {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Task> q = new PriorityQueue<Task>();
        int time = 0;
        int numTasks = Integer.parseInt(buff.readLine().trim());
        for (int i = 0; i < numTasks; i++) {
            String[] arr = buff.readLine().trim().split(" ");
            int deadline =  
        }
    }
}
