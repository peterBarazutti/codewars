package three_kyu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PathFinderDjikstra {

    static int[][] topographicMap;
    static int[][] adjacentDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<Cell> cellsToBeVisited;
    static List<Cell> shortestRoute;

    private class Cell extends Point implements Comparable<Cell> {

        Integer value;

        public Cell(int x, int y) {
            super(x, y);
        }

        public Cell(int x, int y, Integer value) {
            super(x, y);
            this.value = value;
        }

        @Override
        public int compareTo(Cell cell) {
            return this.value.compareTo(cell.value);
        }
    }

    public static int pathFinder(String maze) {
        PathFinderDjikstra pfd = new PathFinderDjikstra();
        cellsToBeVisited = new ArrayList<>();
        shortestRoute = new ArrayList<>();
        pfd.parseMazeString(maze);
        while (cellsToBeVisited.size() > 0) {
            Cell nextCell = cellsToBeVisited
                    .stream()
                    .filter(cell -> cell.value < 1000)
                    .min(Cell::compareTo)
                    .get();
            updateAdjecentCells(nextCell);
        }
        return shortestRoute
                .stream()
                .filter(cell -> cell.x == topographicMap[0].length - 1 && cell.y == topographicMap.length - 1)
                .findFirst()
                .get().value;
    }

    private void parseMazeString(String maze) {
        String[] rows = maze.split("\\n");
        int rowNumber = rows.length;
        int colNumber = rows[0].length();
        topographicMap = new int[rowNumber][colNumber];

        for (int i = 0; i < rowNumber; i++) {
            String[] temp = rows[i].split("");
            for (int j = 0; j < colNumber; j++) {
                cellsToBeVisited.add(new Cell(j, i, 1000));
                topographicMap[i][j] = Integer.parseInt(temp[j]);
            }
        }
        cellsToBeVisited.get(0).value = 0;
    }

    private static void updateAdjecentCells(Cell baseCell) {
        shortestRoute.add(baseCell);
        cellsToBeVisited.remove(baseCell);
        for (int[] dir : adjacentDirections) {
            int nextCellRow = baseCell.y + dir[0];
            int nextCellCol = baseCell.x + dir[1];

            boolean isNotVisited = cellsToBeVisited
                    .stream()
                    .anyMatch(cell -> cell.x == nextCellCol && cell.y == nextCellRow);
            if (isNotVisited) {
                Cell nextCell = cellsToBeVisited
                        .stream()
                        .filter(cell -> cell.x == nextCellCol && cell.y == nextCellRow)
                        .findFirst()
                        .get();
                int distance = Math.abs(topographicMap[baseCell.y][baseCell.x] - topographicMap[nextCellRow][nextCellCol]);
                int newValue = baseCell.value + distance;
                if (newValue < nextCell.value) nextCell.value = newValue;
            }
        }
    }

}
