package three_kyu;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BattleField {

    static Queue<Point> cells = new LinkedList<>();
    static List<Integer> shipList = new ArrayList<>();
    static List<Integer> referenceShipList = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 4));
    static int[][] diagonalDirections = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static int[][] neighbourDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean fieldValidator(int[][] field) {

        initCells(field);

        while (cells.size() > 0) {
            Point cell = cells.poll();
            if (!checkAroundCell(cell, field)) return false;
            int shipFound = determineShipType(cell, field);
            if (shipFound > 0) shipList.add(shipFound);
        }
        Collections.sort(shipList);
        if (!shipList.equals(referenceShipList)) return false;
        return true;
    }

    private static Integer determineShipType(Point baseCell, int[][] table) {
        int nextCellCol, nextCellRow;
        int shipSize = 0;
        int maxCord = table.length;
        boolean cellNotTestedYet = cells.contains(new Point(baseCell.x, baseCell.y));
        if (table[baseCell.y][baseCell.x] == 1 && cellNotTestedYet) {
            shipSize++;
            for (int[] direction : Arrays.copyOf(neighbourDirections, 2)) {
                nextCellCol = baseCell.x + direction[1];
                nextCellRow = baseCell.y + direction[0];
                if (
                        !(nextCellCol < 0) && !(nextCellCol >= maxCord) &&
                                !(nextCellRow < 0) && !(nextCellRow >= maxCord)
                        ) {
                    Point nextCell = new Point(nextCellCol, nextCellRow);
                    shipSize += determineShipType(nextCell, table);
                }
            }
        }
        return shipSize;
    }

    private static boolean checkAroundCell(Point baseCell, int[][] table) {
        int satCellCol, satCellRow;
        int maxCoord = table.length;
        if (table[baseCell.y][baseCell.x] == 1) {
            for (int[] direction : diagonalDirections) {
                satCellCol = baseCell.x + direction[1];
                satCellRow = baseCell.y + direction[0];
                if (
                        !(satCellCol < 0) && !(satCellCol >= maxCoord) &&
                                !(satCellRow < 0) && !(satCellRow >= maxCoord)
                        ) {
                    if (table[satCellRow][satCellCol] == 1) return false;
                }
            }

            int counter = 0;
            for (int[] direction : neighbourDirections) {
                satCellCol = baseCell.x + direction[1];
                satCellRow = baseCell.y + direction[0];
                if (
                        !(satCellCol < 0) && !(satCellCol >= maxCoord) &&
                                !(satCellRow < 0) && !(satCellRow >= maxCoord)
                        ) {
                    if (table[satCellRow][satCellCol] == 1) counter++;
                }
            }
            if (counter > 1) return false;
        }
        return true;
    }

    private static void initCells(int[][] field) {
        for (int r = 0, c = 0; r < field.length; ) {
            if (c < field.length) {
                cells.add(new Point(c, r));
                c++;
            } else {
                c = 0;
                r++;
            }
        }
    }

}
