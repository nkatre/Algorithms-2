public class SquareRootTest {

    public static void main(String args[]) {
        double val = 2.00;
        double base = 4.0;
        double precision = 0.00001;
        assert (SquareRoot.findSquareRoot(base,precision)-val < 0.0001);
        double[] bases = {64.0,9.0,8.0,19283.00, 0.25, 0.77};
        for (double dbl : bases)
            System.out.println("Input: "+dbl+" Output: "+SquareRoot.findSquareRoot(dbl,precision));
        
        System.out.println("done");
    }
}
