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

        BigInteger multiplier = BigInteger.valueOf(deduped.indexOf(word.substring(0,1)));

        BigInteger denominator = BigInteger.valueOf(1);

        for (String letter : deduped) {
            List<String> tempList = new ArrayList<>(charList);
            tempList.remove(letter);
            denominator.multiply(
                    BigInteger.valueOf(
                            calcFactorial(Collections.frequency(tempList, letter))));
        }

        BigInteger variations = multiplier.multiply(nominator.divide(denominator));
        BigInteger leftover = BigInteger.ZERO;
        if (word.length() > 1) {
            leftover = listPosition(word.substring(1, word.length()));
        } else {
            return BigInteger.valueOf(1);
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
