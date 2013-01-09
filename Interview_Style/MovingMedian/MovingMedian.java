/* 
 * Given an array of integers, return an array structured as follows:
 * for index i of the original array, the new array should contain the
 * median of all elements indexed 0 to i, inclusive.
 *
 * @author  Sanjay Paul
 * @date    01.08.2013
 *
 */

import java.util.*;

public class MovingMedian {

    public static int[] calculateMovingMedianArray(int[] arr) {
        if (arr == null || arr.length <=1) return arr;

        PriorityQueue<Integer> l = new PriorityQueue<Integer>(arr.length/2 + 3);
        PriorityQueue<Integer> r = new PriorityQueue<Integer>(arr.length/2 + 3, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if ((int)i1 == (int)i2) return 0;
                return (int)i1 - (int)i2;
            }
        });

        int[] output = new int[arr.length];
        output[0] = arr[0];
        output[1] = (arr[0] + arr[1]) / 2;

        l.add(Math.min(arr[0],arr[1]));
        r.add(Math.max(arr[0],arr[1]));

        for (int i = 2; i < arr.length; i++) {
            int val = arr[i];
            boolean lbool = (val < l.peek());
            boolean rbool = (val > r.peek());

            // Element is in between top values of each queue
            if (!lbool && !rbool) {
                if (r.size() > l.size()) {
                    output[i] = (val + r.peek()) / 2;
                    l.add(val);
                    continue;
                }
                else {
                    if (r.size() < l.size()) {
                        output[i] = (val + l.peek()) /2; 
                        r.add(val);
                        continue;
                    } else {
                        output[i] = val;
                        r.add(val);
                        continue;
                    }
                }
            } else {
               // Element belongs in left queue
               if(lbool) {
                   if (l.size() > r.size()) {
                       l.add(val);
                       r.add(l.poll());
                       output[i] = (l.peek() + r.peek()) / 2;
                   } else {
                       if (r.size() > l.size()) {
                           l.add(val);
                           output[i] = (l.peek() + r.peek()) / 2;
                       } else {
                           l.add(val);
                           output[i] = l.peek();
                       }
                   }
               }
               // Element belongs in right queue
               else {
                    if (l.size() > r.size()) {
                        r.add(val);
                        output[i] = (l.peek() + r.peek()) / 2;
                    } else {
                       if (r.size() > l.size()) {
                           r.add(val);
                           l.add(r.poll());
                           output[i] = (l.peek() + r.peek()) / 2;
                       } else {
                           r.add(val);
                           output[i] = r.peek();
                       }
                   }
               }
            }
        }

        return output;
    }
}
