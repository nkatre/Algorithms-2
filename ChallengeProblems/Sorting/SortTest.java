import java.util.*;

public class SortTest {

    public static void main(String args[]) {
        int[][] arrs = {{2,3,-1,3,20},{8,2,203,-21},{9},{}};
        for (int[] arr: arrs) {
            int[] sorted = Arrays.copyOf(arr,arr.length);
            Arrays.sort(sorted);
            if(!Arrays.equals(sorted,Sort.mergeSort(arr))) {
                System.out.print("Failed Test. Expected : {");   
                for (int val : sorted)
                    System.out.print(val+",");
                System.out.print("} but got : {");
                for (int val : Sort.mergeSort(arr))
                    System.out.print(val+",");
                System.out.println("}.");
            };
        }
        System.out.println("done");
    }
}
