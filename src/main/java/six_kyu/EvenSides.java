package six_kyu;

import java.util.Arrays;

public class EvenSides {

    public int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sumLeft = Arrays.stream(Arrays
                    .copyOfRange(arr, 0, i))
                    .reduce(0, (a, b) -> a + b);
            int sumRight = Arrays.stream(Arrays
                    .copyOfRange(arr, i + 1, arr.length))
                    .sum();
            if (sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }
}
