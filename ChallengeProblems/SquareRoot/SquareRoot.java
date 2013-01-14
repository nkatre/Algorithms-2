public class SquareRoot {

    public static double findSquareRoot(double base, double epsilon) {
        if (base == 1.0)
            return 1.0;
        double low = 1.0;
        double high = base;
        if (base < 1.0) {
            low = 0.0;
            high = 1.0;
        }
        
        while (high - low > epsilon) {
            double mid = (high + low) / 2;
            double square = mid * mid;
            if (square == base) return mid;
            if (square > base)
                high = mid;
            else
                low = mid;
        }

        return high;
    }
}
