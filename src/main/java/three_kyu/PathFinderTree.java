package three_kyu;

import java.util.*;

public class PathFinderTree {

    static int[][] topographicMap;
    static int[][] adjacentDirections = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<PathNode> nodesToBeVisited;
    static List<PathNode> shortestRoute;

    public class PathNode implements Comparable<PathNode> {
        int x, y;
        int value;
        PathNode right, down, left, up;

        public PathNode(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public void updateNeighbour(int index, PathNode neighbour) {
            switch (index) {
                case 0:
                    this.right = neighbour;
                    break;
                case 1:
                    this.down = neighbour;
                    break;
                case 2:
                    this.left = neighbour;
                    break;
                case 3:
                    this.up = neighbour;
                    break;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;
            if (obj.getClass() == PathNode.class) {
                PathNode node = (PathNode) obj;
                if (this.x == node.x && this.y == node.y) return true;
            }
            return false;
        }

        @Override
        public int compareTo(PathNode o) {
            return this.value - o.value;
        }

        public PathNode[] getAdjacentNodes() {
            return new PathNode[]{right, down, left, up};
        }
    }

    public static int pathFinder(String maze) {
        nodesToBeVisited = new ArrayList<>();
        shortestRoute = new ArrayList<>();
        parseMazeString(maze);
        PathFinderTree pf = new PathFinderTree();
        pf.arrayToTree(new int[]{0, 0});
        while (nodesToBeVisited.size() > 0) {
            PathNode nextNode = nodesToBeVisited
                    .stream()
                    .min(PathNode::compareTo)
                    .get();
            updateAdjacentNodes(nextNode);
        }
        return shortestRoute
                .stream()
                .filter(node -> node.x == topographicMap[0].length - 1 && node.y == topographicMap.length - 1)
                .findAny()
                .get().value;
    }

    private static void updateAdjacentNodes(PathNode baseNode) {
        shortestRoute.add(baseNode);
        nodesToBeVisited.remove(baseNode);
        for (PathNode nextNode : baseNode.getAdjacentNodes()) {
            boolean isNotFinal = nodesToBeVisited.contains(nextNode);
            if (isNotFinal) {
                int distance = Math.abs(topographicMap[baseNode.y][baseNode.x] - topographicMap[nextNode.y][nextNode.x]);
                int newValue = baseNode.value + distance;
                if (newValue < nextNode.value) nextNode.value = newValue;
            }
        }
    }

    private void arrayToTree(int[] entryCell) {
        createTreeNode(entryCell, 0);
    }

    private PathNode createTreeNode(int[] cellCords, int initValue) {
        PathNode baseNode;
        int x = cellCords[0];
        int y = cellCords[1];
        baseNode = new PathNode(x, y, initValue);
        nodesToBeVisited.add(baseNode);

        for (int i = 0; i < adjacentDirections.length; i++) {
            int nextNodeX = x + adjacentDirections[i][1];
            int nextNodeY = y + adjacentDirections[i][0];
            if (nextNodeX >= 0 && nextNodeX < topographicMap[0].length && nextNodeY >= 0 && nextNodeY < topographicMap.length) {
                Optional<PathNode> nextNode = nodesToBeVisited
                        .stream()
                        .filter(n -> n.x == nextNodeX && n.y == nextNodeY)
                        .findAny();
                if (nextNode.isPresent()) {
                    baseNode.updateNeighbour(i, nextNode.get());
                } else {
                    baseNode.updateNeighbour(i, createTreeNode(new int[]{nextNodeX, nextNodeY}, 1000));
                }
            }
        }
        return baseNode;
    }

    private static void parseMazeString(String maze) {
        String[] rows = maze.split("\\n");
        int rowNumber = rows.length;
        int colNumber = rows[0].length();
        topographicMap = new int[rowNumber][colNumber];

        for (int i = 0; i < rowNumber; i++) {
            String[] temp = rows[i].split("");
            for (int j = 0; j < colNumber; j++) {
                topographicMap[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

}
