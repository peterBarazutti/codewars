package four_kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringMix {

    public static String mix(String s1, String s2) {
        String strippedS1 = s1.replaceAll("[A-Z]", "").replaceAll(" ","");
        List<String> s1CharList = Arrays.asList(strippedS1.split(""));
        String strippedS2 = s2.replaceAll("[A-Z]", "").replaceAll(" ","");
        List<String> s2CharList = Arrays.asList(strippedS2.split(""));

        char[] charArray = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();

        List<String> resultList = new ArrayList<>();
        for (char ch : charArray) {
            int charCount1 = Collections.frequency(s1CharList, String.valueOf(ch));
            int charCount2 = Collections.frequency(s2CharList, String.valueOf(ch));
            if (charCount1 > 1 || charCount2 > 1) {
                String repeated = new String(new char[charCount1]).replace("\0", String.valueOf(ch));
                if (charCount1 == charCount2) {
                    resultList.add("=:" + repeated);
                } else if (charCount1 > charCount2) {
                    resultList.add("1:" + repeated);
                } else if (charCount2 > charCount1) {
                    repeated = new String(new char[charCount2]).replace("\0", String.valueOf(ch));
                    resultList.add("2:" + repeated);
                }
            }
        }

        List<String> temp = resultList.stream().sorted((str1, str2) -> {
            return str2.length()-str1.length();
        } ).collect(Collectors.toList());

        List<String> temp2 = temp.stream().sorted((str1, str2) -> {
           if (str1.length() == str2.length()) {
               return str1.compareTo(str2);
           }
           return 1;
        }).collect(Collectors.toList());

        return String.join("/", temp2);
    }

}
