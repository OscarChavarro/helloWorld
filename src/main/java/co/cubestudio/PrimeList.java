package co.cubestudio;

public class PrimeList {
    static boolean checkPrime(int n) {
        if ( n == 0 || n == 1 ) {
            return false;
        } else {
            boolean flag = false;

            int m = n / 2;
            for ( int i = 2; i <= m; i++ ) {
                if ( n % i == 0 ) {
                    flag = true;
                    break;
                }
            }
            return !flag;
        }
    }

    public static void main(String[] args) {
        for ( int i = 0; i >= 0 && i <= Integer.MAX_VALUE; i++ ) {
            if ( checkPrime(i) ) {
                System.out.println(i);
            }
        }
    }
}
