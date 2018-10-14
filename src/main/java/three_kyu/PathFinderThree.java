package three_kyu;


import java.util.*;
import java.util.function.Predicate;

public class PathFinderThree {

    static int[][] topographicMap;
    static int[][] adjacentDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Map<List<Integer>, Integer> cellsToBeVisited;
    static Map<List<Integer>, Integer> shortestRoute;

    public static int pathFinder(String maze) {
        cellsToBeVisited = new HashMap<>();
        shortestRoute = new HashMap<>();
        parseMazeString(maze);
        while (cellsToBeVisited.size() > 0) {
            Map.Entry<List<Integer>, Integer> nextCell = cellsToBeVisited.entrySet()
                    .stream()
                    .filter(cell -> cell.getValue() < 1000)
                    .min(Comparator.comparing(Map.Entry::getValue))
                    .get();
            updateAdjecentCells(nextCell.getKey(), nextCell.getValue());
        }
        return shortestRoute
                .entrySet()
                .stream()
                .filter(getEntryPredicate(topographicMap.length - 1, topographicMap[0].length - 1))
                .findFirst()
                .get().getValue();
    }
    private static void parseMazeString(String maze) {
        String[] rows = maze.split("\\n");
        int rowNumber = rows.length;
        int colNumber = rows[0].length();
        topographicMap = new int[rowNumber][colNumber];

        for (int i = 0; i < rowNumber; i++) {
            String[] temp = rows[i].split("");
            for (int j = 0; j < colNumber; j++) {
                cellsToBeVisited.put(new ArrayList<>(Arrays.asList(j,i)), 1000);
                topographicMap[i][j] = Integer.parseInt(temp[j]);
            }
        }
        cellsToBeVisited.put(new ArrayList<>(Arrays.asList(0,0)), 0);
    }

    private static void updateAdjecentCells(List<Integer> baseCellCords, Integer baseCellValue) {
        shortestRoute.put(baseCellCords, baseCellValue);
        cellsToBeVisited.remove(baseCellCords);
        for (int[] dir : adjacentDirections) {
            int nextCellRow = baseCellCords.get(1) + dir[0];
            int nextCellCol = baseCellCords.get(0) + dir[1];

            boolean isNotVisited = cellsToBeVisited
                    .entrySet()
                    .stream()
                    .anyMatch(getEntryPredicate(nextCellRow, nextCellCol));
            if (isNotVisited) {
                Map.Entry<List<Integer>, Integer> nextCell = cellsToBeVisited
                        .entrySet()
                        .stream()
                        .filter(getEntryPredicate(nextCellRow, nextCellCol))
                        .findFirst()
                        .get();
                int distance = Math.abs(topographicMap[baseCellCords.get(1)][baseCellCords.get(0)] - topographicMap[nextCellRow][nextCellCol]);
                int newValue = baseCellValue + distance;
                if (newValue < nextCell.getValue()) cellsToBeVisited.put(nextCell.getKey(), newValue);
            }
        }
    }

    private static Predicate<Map.Entry<List<Integer>, Integer>> getEntryPredicate(int nextCellRow, int nextCellCol) {
        return cell -> cell.getKey().get(0) == nextCellCol && cell.getKey().get(1) == nextCellRow;
    }


}
