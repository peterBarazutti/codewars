package three_kyu;

public class Spiralizor {

    static int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int[][] spiralize(int size) {
        int[] rows = new int[size];
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            table[i] = rows.clone();
        }

        int rowIndex = 0;
        int colIndex = 0;
        int directionIndex = 0;

        int[] nextStep = steps[directionIndex];
        int counter = 0;
        table[rowIndex][colIndex] = 1;
        while (true) {
            if (!mustTurn(rowIndex, colIndex, nextStep, table)) {
                rowIndex += nextStep[0];
                colIndex += nextStep[1];
                table[rowIndex][colIndex] = 1;
                counter = 0;
            } else {
                nextStep = steps[++directionIndex % 4];
                int[] nextNextStep = steps[(directionIndex+1) % 4];
                if (foundEnd(rowIndex, colIndex, nextStep, nextNextStep, table)) break;
                counter++;
            }
            if (counter == 4) break;
        }
        return table;
    }

    private static boolean foundEnd(int rowIndex, int colIndex, int[] nextStep, int[] nextNextStep, int[][] table) {
        int checkedCellRowIndex = rowIndex + nextStep[0]+ nextNextStep[0];
        int checkedCellColIndex = colIndex + nextStep[1]+ nextNextStep[1];
        if (table[checkedCellRowIndex][checkedCellColIndex] == 1) return true;
        else return false;
    }

    private static boolean mustTurn(int rowIndex, int colIndex, int[] nextStep, int[][] table) {
        int nextRowIndex = rowIndex+nextStep[0];
        int nextColIndex = colIndex+nextStep[1];
        if (nextRowIndex < 0 || nextRowIndex>= table.length
                || nextColIndex <0 || nextColIndex >= table.length) {
            return true;
        }
        int nextNextRowIndex = rowIndex + 2 * nextStep[0];
        int nextNextColIndex = colIndex + 2 * nextStep[1];
        if (nextNextColIndex < 0 || nextNextColIndex >= table.length
                || nextNextRowIndex < 0 || nextNextRowIndex >= table.length) {
            return false;
        } else {
            if (table[nextNextRowIndex][nextNextColIndex] == 1) return true;
        }
        return false;
    }
}
