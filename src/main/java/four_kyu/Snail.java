package four_kyu;

import java.util.ArrayList;
import java.util.List;

public class Snail {

    public static int[] snail(int[][] array) {
        if (array[0].length == 0) {
            return new int[]{};
        }
        List<Integer> traversedCells = new ArrayList<>();
        int numberOfElements = (int) Math.pow(array.length, 2);
        int xCoord = 0;
        int yCoord = 0;
        int[] result = new int[numberOfElements];
        int counter = 0;
        int directionIndex = 0;
        result[counter++] = array[xCoord][yCoord];
        traversedCells.add(xCoord * 10 + yCoord);
        int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] nextStep = steps[directionIndex];
        while (traversedCells.size() < numberOfElements) {
            int rowIndex = xCoord + nextStep[0];
            int columnIndex = yCoord + nextStep[1];
            int storedStep = rowIndex * 10 + columnIndex;
            if (rowIndex >= 0 && rowIndex < array.length
                    && columnIndex >= 0 && columnIndex < array.length
                    && !traversedCells.contains(storedStep)) {
                xCoord = rowIndex;
                yCoord = columnIndex;
                traversedCells.add(storedStep);
                System.out.println(array[rowIndex][columnIndex]);
                result[counter++] = array[xCoord][yCoord];
            } else {
                nextStep = steps[++directionIndex % 4];
            }
        }
        return result;
    }
}
