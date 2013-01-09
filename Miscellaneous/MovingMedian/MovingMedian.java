/* 
 * Given an array of integers, return an array structured as follows:
 * for index i of the original array, the new array should contain the
 * median of all elements indexed 0 to i, inclusive.
 *
 * @author  Sanjay Paul
 * @date    01.08.2013
 *
 */

public class MovingMedian {

    public static int[] calculateMovingMedianArray(int[] arr) {
        PriorityQueue<Integer> l = new PriorityQueue<Integer>(arr.length/2);
        PriorityQueue<Integer> r = new PriorityQueue<Integer>(arr.length/2 + 1);

        int[] output = new int[arr.length];

        l.add(-1*Math.min(arr[0],arr[1]));
        r.add(Math.max(arr[0],arr[1]));

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            boolean lbool = (val <= -1*l.peek());
            boolean rbool = (val >= r.peek());

            // Element is in between top values of each queue
            if (!lbool && !rbool) {
                if (r.size() > l.size()) {
                    output[i] = (val + r.peek()) / 2;
                    l.add(-1 * val);
                    continue;
                }
                else {
                    if (r.size() < l.size()) {
                        output[i] = (val + -1*l.peek()) /2; 
                        r.add(val);
                        continue;
                    } else {
                        output[i] = val;
                        r.add(val);
                        continue;
                    }
                }
            } else {
               if(lbool 
            }
        }
    }
}
