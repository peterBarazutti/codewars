package three_kyu;

import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fib(BigInteger n) {
        BigInteger result = fibIter(BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE, n);
        if (n.signum() == -1 && n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) result = result.negate();
        return result;
    }

    private static BigInteger fibIter(BigInteger a, BigInteger b, BigInteger p, BigInteger q, BigInteger count) {
        BigInteger result = b;
        if (!count.equals(BigInteger.ZERO)) {
            if (count.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                BigInteger A1 = q.pow(2).add(p.pow(2));
                BigInteger A2 = q.pow(2).add(p.multiply(q).multiply(BigInteger.valueOf(2)));
                BigInteger A3 = p.multiply(q).multiply(BigInteger.valueOf(2)).subtract(p.pow(2));

                BigInteger qSSNom = b.pow(2).multiply(A2).add(a.multiply(b).multiply(A2.multiply(BigInteger.valueOf(2)).subtract(A3).subtract(A1))).subtract(a.pow(2).multiply(A2));
                BigInteger pSSNom = b.pow(2).multiply(A1).add(a.pow(2).multiply(A3.subtract(A2))).add(a.multiply(b).multiply(A1));
                BigInteger denom = b.pow(2).add(a.multiply(b)).subtract(a.pow(2));

                BigInteger pSS = pSSNom.divide(denom);
                BigInteger qSS = qSSNom.divide(denom);

                result = fibIter(a, b, pSS, qSS, count.divide(BigInteger.valueOf(2)));
            } else {
                BigInteger temp = a;
                a = b.multiply(q).add(a.multiply(q).add(a.multiply(p)));
                b = b.multiply(p).add(temp.multiply(q));

                if (count.signum() == -1) {
                    count = count.add(BigInteger.ONE);
                } else {
                    count = count.subtract(BigInteger.ONE);
                }

                result = fibIter(a, b, p, q, count);
            }
        }
        return result;
    }

}
