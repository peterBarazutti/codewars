package three_kyu;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BattleShip {

    static Queue<Point> cellsToBeChecked;
    static List<Integer> shipList;
    static List<Integer> referenceShipList = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 4));
    static int[][] diagonalDirections = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static int[][] neighbourDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean fieldValidator(int[][] field) {
        int counter = 0;

        cellsToBeChecked = new LinkedList<>();
        shipList = new ArrayList<>();

        initCells(field);

        while (cellsToBeChecked.size() > 0) {
            Point cell = cellsToBeChecked.poll();
            int shipFound = lookForShip(cell, field);
            if (shipFound < 0) return false;
            else if (shipFound > 0) shipList.add(shipFound);
        }
        Collections.sort(shipList);
        if (!shipList.equals(referenceShipList)) return false;
        return true;
    }

    private static int lookForShip(Point cell, int[][] board) {
        int shipSize = 0;
        List<Point> nextShipElem = new ArrayList<>();
        if (board[cell.y][cell.x] == 1) {
            shipSize++;
            nextShipElem.addAll(checkAdjacentCells(cell, board));
            if (checkDiagonalCells(cell, board) || nextShipElem.size() > 1) return -1;
            else if (nextShipElem.size() == 1) {
                Point nextCell = nextShipElem.get(0);
                if (cellsToBeChecked.contains(nextCell)) {
                    cellsToBeChecked.remove(nextCell);
                    int shipSizeIter = lookForShip(nextCell, board);
                    if (shipSizeIter == -1) return -1;
                    shipSize += shipSizeIter;
                }
            }
        }
        return shipSize;
    }

    // returns true if board is invalid
    private static boolean checkDiagonalCells(Point baseCell, int[][] table) {
        int satCellCol, satCellRow;
        int maxCoord = table.length;
        for (int[] direction : diagonalDirections) {
            satCellCol = baseCell.x + direction[1];
            satCellRow = baseCell.y + direction[0];
            if (
                    !(satCellCol < 0) && !(satCellCol >= maxCoord) &&
                            !(satCellRow < 0) && !(satCellRow >= maxCoord)
                    ) {
                if (table[satCellRow][satCellCol] == 1) return true;
            }
        }
        return false;
    }

    private static List<Point> checkAdjacentCells(Point baseCell, int[][] board) {
        List<Point> shipsFound = new ArrayList<>();
        int satCellCol, satCellRow;
        int maxCord = board.length;
        for (int[] direction : neighbourDirections) {
            satCellCol = baseCell.x + direction[1];
            satCellRow = baseCell.y + direction[0];
            if (
                    !(satCellCol < 0) && !(satCellCol >= maxCord) &&
                            !(satCellRow < 0) && !(satCellRow >= maxCord)
                    ) {
                Point nextCell = new Point(satCellCol, satCellRow);
                if (board[satCellRow][satCellCol] == 1 && cellsToBeChecked.contains(nextCell)) shipsFound.add(nextCell);
            }
        }
        return shipsFound;
    }

    private static void initCells(int[][] field) {
        for (int r = 0, c = 0; r < field.length; ) {
            if (c < field.length) {
                cellsToBeChecked.add(new Point(c, r));
                c++;
            } else {
                c = 0;
                r++;
            }
        }
    }

}
