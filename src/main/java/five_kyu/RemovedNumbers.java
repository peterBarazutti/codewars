package five_kyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

// https://www.codewars.com/kata/is-my-friend-cheating/train/java
public class RemovedNumbers {

    /*static List<Long> interval;

    public List<long[]> removeNb(long n) {

        List<long[]> result = new ArrayList<>();

        interval = LongStream.range(1L, n + 1)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < interval.size() - 1; i++) {
            for (int j = i+1; j < interval.size(); j++) {
                    long sum = calcSum(i, j);
                    if (i * j == sum) {
                        result.add(new long[]{(long) i, (long) j});
                    }
            }
        }

        List<long[]> invertedResult = result.stream()
                .map(arr -> {
                    long[] temp = new long[2];
                    temp[0] = arr[1];
                    temp[1] = arr[0];
                    return temp;
                })
                .collect(Collectors.toList());
        result.addAll(invertedResult);
        return result;
    }

    private static long calcSum(int i, int j) {
        return interval.stream()
                .filter(num -> !num.equals((long) i) && !num.equals((long) j))
                .reduce(0L, (a, b) -> a + b);
    }*/

    public List<long[]> removeNb(long n) {
        List<long[]> result = new ArrayList<>();
        long sum = LongStream.rangeClosed(1L, n).sum();
        long leftIndex = 1;
        long rightIndex = n;
        while (rightIndex > leftIndex){
            long tempSum = sum - ( leftIndex + rightIndex);
            long tempProd = leftIndex * rightIndex;
            if (tempSum == tempProd) {
                result.add(new long[]{leftIndex, rightIndex});
                result.add(new long[]{rightIndex, leftIndex});
                leftIndex++;
            } else if (tempSum > tempProd) {
                leftIndex++;
            } else if (tempProd > tempSum) {
                rightIndex--;
            }
        }
        /*List<long[]> invertedResult = result.stream()
                .map(arr -> {
                    long[] temp = new long[2];
                    temp[0] = arr[1];
                    temp[1] = arr[0];
                    return temp;
                })
                .collect(Collectors.toList());
        result.addAll(invertedResult);*/
        result.sort((arr1, arr2) ->{
            return (int) (arr1[0]-arr2[0]);
        });
        return result;
    }


}
