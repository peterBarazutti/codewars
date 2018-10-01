import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimePalin {

    public static String backwardsPrime(long start, long end) {
        double ceiling = Math.pow(10, Math.ceil(Math.log10(end)));
        Set<Integer> notPrimeList = new HashSet<>();
        for (int i = 2; i < Math.sqrt(ceiling); i++) {
            if (!notPrimeList.contains(i)) {
                for (int j = 2 * i; j < ceiling; j += i) {
                    notPrimeList.add(j);
                }
            }
        }
        List<Integer> resultList = IntStream
                .range(2, (int) ceiling)
                .parallel()
                .filter(x->!notPrimeList.contains(x))
                .map(PrimePalin::reverseNumber)
                .filter(x -> x > start && x < end )
                .filter(x -> !notPrimeList.contains(x))
                .boxed()
                .filter(x -> !x.equals(reverseNumber(x)))
                .sorted()
                .collect(Collectors.toList());
/*        List<Integer> resultList = primeList
                .stream()
                .parallel()
                .filter(x -> x > start && x < end && primeList.contains(reverseNumber(x)) && !x.equals(reverseNumber(x)))
                .collect(Collectors.toList());*/
        String result = resultList.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        return result;
    }

    /*public static String backwardsPrime(long start, long end) {
        double ceiling = Math.pow(10, Math.ceil(Math.log10(end)));
        Set<Integer> notPrimeList = new HashSet<>();
        for (int i = 2; i < Math.sqrt(ceiling); i++) {
            if (!notPrimeList.contains(i)) {
                for (int j = 2 * i; j < ceiling; j += i) {
                    notPrimeList.add(j);
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < (int) ceiling; i++) {
            if (!notPrimeList.contains(i)){
                primeList.add(i);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (Integer num: primeList) {
            if (num>=start && num<=end && primeList.contains(reverseNumber(num)) && !num.equals(reverseNumber(num))){
                resultList.add(num);
            }
        }
        String result = resultList.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        return result;
    }
*/
    /*public static Integer reverseNumber(int num) {
        Integer res = 0;
        if (num >= 10) {
            double temp = num % 10 * Math.pow(10, String.valueOf(num).length() - 1);
            return (int) temp + reverseNumber(num / 10);
        }
        return res + num;
    }*/
    public static Integer reverseNumber(Integer num) {
        StringBuilder sb = new StringBuilder(num+"");
        return Integer.parseInt(new String(""+sb.reverse()));
    }
}
