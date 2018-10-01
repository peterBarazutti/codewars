package five_kyu;

import java.util.*;


//exceeds time limit on codewars!!!
//TODO optimize code
public class BestTravel {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        Set<List<Integer>> routeCombinationSet = new HashSet<>();
        routeCombinations(k, new ArrayList<>(ls), routeCombinationSet);
        Optional<Integer> bestRoute = routeCombinationSet.stream()
                .map(atomicList -> atomicList.stream().reduce(0, (num1, num2) -> num1 + num2))
                .filter(sum -> sum <= t)
                .max((x, y) -> {
                        if (x > y) return 1;
                        else if (x < y) return -1;
                        else return 0;
                });
        if (bestRoute.isPresent()){
            return  bestRoute.get();
        } else {
            return null;
        }
    }
/*
    private Integer simpleComparator(int x, int y){
        if (x>y) return 1;
        else if (x<y) return -1;
        else return 0;
    }*/

    private static void routeCombinations(int n, List<Integer> routeList, Set<List<Integer>> routeCombinationSet) {
        Set<List<Integer>> routeCombinationIndexSet = new HashSet<>();

        Random rng = new Random();
        for (int i = 0; i < 100000; i++) {
            List<Integer> temp = new ArrayList<>();
            while (temp.size() < n){
                Integer intNum = rng.nextInt(routeList.size());
                if (!temp.contains(intNum)) {
                    temp.add(intNum);
                    Collections.sort(temp);
                }
            }
            routeCombinationIndexSet.add(temp);
        }

        for (List<Integer> atomicList: routeCombinationIndexSet) {
            List<Integer> tempList = new ArrayList<>();
            for (Integer num:atomicList) {
                tempList.add(routeList.get(num));
            }
            routeCombinationSet.add(tempList);
        }
    }


    /*public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        routeCombinations(k, new ArrayList<>(ls));
        Optional<List<Integer>> bestRoute = routeCombinationSet.stream()
                .filter(
                        x -> sumOfList(x) < t
                )
                .max((x, y) -> {
                    if (sumOfList(x) > sumOfList(y)) return 1;
                    else if (sumOfList(x) < sumOfList(y)) return -1;
                    else return 0;
                });
        System.out.println(bestRoute.get());
        return 0;
    }*/

    /*private static void routeCombinations(int n, List<Integer> routeList, Set<List<Integer>> routeCombinationSet) {
        if (routeList.size() == n) {
            routeCombinationSet.add(routeList);
            return null;
        } else {
            for (int i = 0; i < routeList.size(); i++) {
                List<Integer> temp = new ArrayList<>(routeList);
                temp.remove(i);
                routeCombinations(n, temp, routeCombinationSet);
            }
        }
    }

    public static void possibleSublists(int sample, int population, Set<List<Integer>> resultCollection){
        Random rng = new Random();
        for (int i = 0; i < 1000000; i++) {
            List<Integer> temp = new ArrayList<>();
            while (temp.size() <=3){
                Integer intNum = rng.nextInt(population);
                if (!temp.contains(intNum)) {
                    temp.add(intNum);
                    temp.sort((x,y) -> {
                        if (x>y) return 1;
                        else if (x<y) return -1;
                        else return 0;
                    });
                }
            }
            resultCollection.add(temp);
        }
        System.out.println(resultCollection.size());
    }*/

}
