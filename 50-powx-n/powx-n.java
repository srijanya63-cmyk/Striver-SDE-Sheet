class Solution {
    public double myPow(double x, int n) {
        long N = n;  
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        
        while (N > 0) {
            // if n is odd
            if ((N % 2) == 1) {
                result = result * x;
            }
            
            // square the base
            x = x * x;
            
            // divide power by 2
            N = N / 2;
        }
        
        return result;
    }
}