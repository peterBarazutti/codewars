package four_kyu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumByFactors {

    public static String sumOfDivided(int[] l) {
        String result = "";
        SortedMap<Integer, List<Integer>> resultMap = new TreeMap<>();
        int max = Arrays.stream(l).map(x -> Math.abs(x)).max().orElseThrow(NoSuchElementException::new);
        List<Integer> primeFactors = IntStream
                .range(2, max)
                .filter(SumByFactors::isPrime)
                .boxed()
                .collect(Collectors.toList());
        for (Integer prime : primeFactors) {
            List<Integer> temp = new ArrayList<>();
            for (Integer num : l) {
                if (num % prime == 0) {
                    temp.add(num);
                }
                if (temp.size() != 0) {
                    resultMap.put(prime, temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry ent : resultMap.entrySet()) {
            int sum = 0;
            for (Object num:(List) ent.getValue()) {
                sum +=  (int) num;
            }
            sb.append("(" + ent.getKey() + " " + sum + ")");
        }
        return sb.toString();
    }

    private static boolean isPrime(int num) {
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
