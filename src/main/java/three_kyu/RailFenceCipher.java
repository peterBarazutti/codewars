package three_kyu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RailFenceCipher {

    public static String encode(String s, int n) {
        String[] railFences = new String[n];
        Arrays.fill(railFences, "");
        int railIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            railFences[railIndex] = railFences[railIndex].concat(String.valueOf(s.charAt(i)));
            if ((i / (n - 1) & 1) != 0) railIndex--;
            else railIndex++;
        }
        return Arrays
                .stream(railFences)
                .collect(Collectors.joining());
    }

    public static String decode(String s, int n) {
        if (s.length() == 0) {
            return "";
        }
        int counter = 0;
        int periodTime = (n - 1) * 2;
        String[] decodedString = new String[s.length()];
        Arrays.fill(decodedString, "");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= s.length() / periodTime + 1; j++) {
                if (j * periodTime - i >= 0 && j * periodTime - i < s.length() && i != n - 1) {
                    decodedString[j * periodTime - i] = String.valueOf(s.charAt(counter++));
                }
                if (j * periodTime + i < s.length() && i != 0) {
                    decodedString[j * periodTime + i] = String.valueOf(s.charAt(counter++));
                }
            }
        }
        return Arrays
                .stream(decodedString)
                .collect(Collectors.joining());
    }

}
