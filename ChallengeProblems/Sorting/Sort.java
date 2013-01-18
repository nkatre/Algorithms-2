import java.util.*;

public class Sort {
    
    public static int[] mergeSort(int[] arr) {
        if (arr==null || arr.length <= 1)
            return arr;
        int index = (arr.length % 2 == 0) ? arr.length/2 : arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, index));
        int[] right = mergeSort(Arrays.copyOfRange(arr, index, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int l_index = 0;
        int r_index = 0;
        int[] output = new int[left.length + right.length];
        int out_index = 0;

        while (l_index < left.length && r_index < right.length) {
            if (left[l_index] <= right[r_index]) {
                output[out_index] = left[l_index];
                l_index++;
            } else {
                output[out_index] = right[r_index];
                r_index++;
            }
            out_index++;
        }

        if (l_index < left.length || r_index < right.length) {
            int[] extra;
            int x_index;
            if (l_index < left.length) {
                extra = left;
                x_index = l_index;
            } else {
                extra = right;
                x_index = r_index;
            }

            for (int i = x_index; i < extra.length; i++,out_index++) {
                output[out_index] = extra[i];
            }
        }

        return output;
    }
}
