package three_kyu;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    public BigInteger listPosition(String word) {
        List<String> charList = new ArrayList<>(Arrays.asList(word.split("")));
        List<String> deduped = charList.stream().distinct().collect(Collectors.toList());
        Collections.sort(deduped);

        BigInteger foundElementNumber = BigInteger.ZERO;

        BigInteger nominator = calcFactorial(charList.size() - 1);

        List<String> beforeChars = deduped.subList(0, deduped.indexOf(String.valueOf(word.charAt(0))));
        for (String beforeLetter : beforeChars) {
            BigInteger denominator = BigInteger.valueOf(1);
            List<String> tempList = new ArrayList<>(charList);
            tempList.remove(beforeLetter);
            for (String letter : deduped) {
                denominator = denominator.multiply(
                        calcFactorial(Collections.frequency(tempList, letter)));
            }
            foundElementNumber = foundElementNumber.add(nominator.divide(denominator));
        }

        BigInteger leftover = BigInteger.ZERO;
        if (word.length() > 1) {
            leftover = listPosition(word.substring(1, word.length()));
        } else {
            return BigInteger.valueOf(1);
        }

        return foundElementNumber.add(leftover);
    }

    public BigInteger calcFactorial(int num) {
        BigInteger result = BigInteger.ONE;
        if (num == 0) return result;
        for (int i = 1; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
