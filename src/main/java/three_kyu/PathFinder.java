package three_kyu;

import java.util.Arrays;
import java.util.LinkedList;

public class PathFinder {


    static int[] minSteps;
    static LinkedList<Integer> toTest;
    static String maze;

    public static int pathFinder(String maze) {
        PathFinder.maze=maze;
        int n = ((int) Math.sqrt(4 * maze.length() + 5) - 1) / 2;
        minSteps = new int[maze.length()];
        Arrays.fill(minSteps,Integer.MAX_VALUE);
        minSteps[minSteps.length - 1] = 0;
        toTest = new LinkedList<>();
        toTest.add(minSteps.length - 1);
        while (!toTest.isEmpty()) {
            int p = toTest.pollFirst();
            int curSteps = minSteps[p];
            int curH=maze.charAt(p)-'0';
            int y = p / (n + 1);
            int x = p - y * (n + 1);
            if (y < n - 1) checkAdd(p + n + 1, curSteps, curH);
            if (x < n - 1) checkAdd(p + 1, curSteps, curH);
            if (y > 0) checkAdd(p - n - 1, curSteps, curH);
            if (x > 0) checkAdd(p - 1, curSteps, curH);
        }
        return minSteps[0];
    }

    private static void checkAdd(int p, int curSteps, int curH) {
        curSteps+=Math.abs(maze.charAt(p)-'0'-curH);
        if (minSteps[p]>curSteps) {
            minSteps[p]=curSteps;
            toTest.add(p);
        }
    }
}