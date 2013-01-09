/* 
 * Tests for moving median functionality.
 *
 * @author  Sanjay Paul
 * @date    01.08.2013 
 */

public class MovingMedianTest {

    private static final int[] input1 = {1,2,3,4,5};
    private static final int[] output1 = {1,1,2,2,3};
    private static final int[] input2 = {1,1,1,1};
    private static final int[] output2 = {1,1,1,1};
    private static final int[] input3 = {1,2,2,2,3};
    private static final int[] output3 = {1,1,2,2,2};

    public static void main(String args[]) { 
        int[][] tests = {input1,output1,input2,output2,input3,output3};
        for (int j = 0; j < tests.length; j+=2) {
            int[] input = tests[j];
            int[] output = tests[j+1];
            int[] result = MovingMedian.calculateMovingMedianArray(input);
            for (int i = 0; i < input.length; i++) {
               if (result[i] != output[i]) {
                System.err.println("Failed test #" + (i+1) + ".");
                for (int a : result)
                    System.err.print(a + " ");
                System.err.println();
                break;
               }
            }
        }
        System.out.println("Done!");
    }
}
