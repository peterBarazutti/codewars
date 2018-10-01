package six_kyu;

import java.util.Arrays;

public class Epidem {

    public static int epidemic(int tm, int n, int s0, int i0, double b, double a) {
        double dt = ((double) tm / (double) n);
        double[] S = new double[n];
        S[0] = s0;
        double[] I = new double[n];
        I[0] = i0;
        double[] R = new double[n];
        R[0] = 0;
        for (int k = 0; k < n-1; k++) {
            S[k + 1] = S[k] - dt * b * S[k] * I[k];
            I[k + 1] = I[k] + dt * (b * S[k] * I[k] - a * I[k]);
            R[k + 1] = R[k] + dt * I[k] * a;
        }
        double result = Arrays.stream(I).max().getAsDouble();
        return (int) result;
    }

}
