package four_kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.codewars.com/kata/twice-linear/train/java
public class DoubleLinear {

    public static int dblLinear(int n) {

        int y, z;
        y = 1;
        z = 1;
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 3, 4));
        while (sequence.size() < n + 1) {
            int numY = 2 * sequence.get(y) + 1;
            int numZ = 3 * sequence.get(z) + 1;
            if (numZ > numY) {
                sequence.add(numY);
                y++;
            } else if (numY > numZ) {
                sequence.add(numZ);
                z++;
            } else if (numY == numZ) {
                sequence.add(numY);
                y++;
                z++;
            }
        }
        return sequence.get(n);
    }
}
