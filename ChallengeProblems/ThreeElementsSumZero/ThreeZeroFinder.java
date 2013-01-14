public class ThreeZeroFinder {
    
    // Given an input array of integers, returns
    // an array of three distinct values that
    // sum to zero or null if this is
    // not possible. Assumes no duplicates.
    public static int[] findZeroes(int[] arr) {
        HashMap<Integer,Integer> intmap 
            = new HashMap<Integer,Integer>();
        for (int val : arr) {
            if(!intmap.containsKey(val))
                intmap.put(val,1);
            else
                intmap.put(val,intmap.get(val)+1);
        }
        int[] output = new int[3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; i++) {
               if(intmap.containsKey( 
            }
        }
        return null; 
    }
}

