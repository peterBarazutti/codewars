package three_kyu;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    public BigInteger listPosition(String word) {
        List<String> charList = new ArrayList<>(Arrays.asList(word.split("")));
        List<String> deduped = charList.stream().distinct().collect(Collectors.toList());
        BigInteger nominator = BigInteger.valueOf(
                calcFactorial(charList.size() - 1));
        Collections.sort(deduped);

        BigInteger multiplier = BigInteger.valueOf(1 + deduped.indexOf(word.substring(0,1)));

        BigInteger denominator = BigInteger.valueOf(1);

        for (String letter : deduped) {
            denominator.multiply(
                    BigInteger.valueOf(
                            calcFactorial(Collections.frequency(charList, letter))));
        }

        BigInteger variations = multiplier.multiply(nominator.divide(denominator));
        BigInteger leftover = BigInteger.ZERO;
        if (word.length() > 1) {
            leftover = listPosition(word.substring(1, word.length()));
        }

        return variations.add(leftover);
    }

    public int calcFactorial(int num) {
        int result = 1;
        if (num == 0) return result;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

}
