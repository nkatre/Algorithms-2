/*
 * Return the median of the combined elements of two arrays 
 * that are provided in sorted order in better than linear
 * time.
 *
 * @author  Sanjay Paul
 * @date    01.09.2013
 *
 */

public class MedianTwoSortedArrays {

    private static int getMedian(int[] arr, int beg, int end) {
        int len = end - beg + 1;
        if (len == 1)
            return 0;
        if (len % 2 == 0)
            return len/2 + beg - 1;
        return len/2 + beg;
    }
    
    public static int getMedianSortedArrays(int[] arr1, int[] arr2) {
        // Ignoring null pointer check because there's no way to 
        // indicate an illegal input using the primitive return.
        // ArrayOutOfBounds and NullPointer Exceptions should be
        // discussed. Other Options: Restrict to positive ints
        // or use the Integer type for the return.

        if (arr1.length==1 && arr2.length==0)
            return arr1[0];
        if (arr2.length==1 && arr1.length==0)
            return arr2[0];

        int size = arr1.length + arr2.length;
        
        int[] lesser = null;
        int[] greater = null;

        // Check if non-overlapping
        if (arr1[arr1.length-1] < arr2[0]) {
            lesser = arr1;
            greater = arr2;
        } else {
            if (arr2[arr2.length-1] < arr1[0]) {
                lesser = arr2;
                greater = arr1;
            }
        }

        // If the arrays are non-overlapping, the case is simple
        // and handled in O(1)
        if (lesser!=null) {
            if (size % 2 == 0) {
                int[] mids = {size/2,size/2 + 1};
                for (int n : mids) {
                    if (n <= lesser.length)
                        sum += lesser[n-1];
                    else
                        sum += greater[n-1-lesser.length];
                }
                return sum/2;
            } else {
                int n = size/2 + 1; // want the n-th number in the order
                if (n <= lesser.length) {
                    return lesser[n - 1];
                } else {
                    return greater[n - lesser.length - 1];
                }
            }
        }

        // If the arrays do overlap, then we need to do some binary searching
        int[] a = arr1;
        int[] b = arr2;
        int a_beg = 0;
        int a_end = a.length - 1;
        int b_beg = 0;
        int b_end = b.length - 1;
        while (true) {
            int i_med1 = getMedian(a, a_beg, a_end);
            int i_med2 = getMedian(b, b_beg, b_end);
            int med1 = arr[i_med1];
            int med2 = arr[i_med2];
            
            if (med1 == med2)
                return med1
            if (med1 > med2) {
                
            }
        }
    }
}
