package two_kyu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MorseCodeDecoderThree {


    static Map<String, String> morseToLetterDict = new HashMap<>();

    static {
        morseToLetterDict.put(".-", "A");
        morseToLetterDict.put("-...", "B");
        morseToLetterDict.put("-.-.", "C");
        morseToLetterDict.put("-..", "D");
        morseToLetterDict.put(".", "E");
        morseToLetterDict.put("..-.", "F");
        morseToLetterDict.put("--.", "G");
        morseToLetterDict.put("....", "H");
        morseToLetterDict.put("..", "I");
        morseToLetterDict.put(".---", "J");
        morseToLetterDict.put("-.-", "K");
        morseToLetterDict.put(".-..", "L");
        morseToLetterDict.put("--", "M");
        morseToLetterDict.put("-.", "N");
        morseToLetterDict.put("---", "O");
        morseToLetterDict.put(".--.", "P");
        morseToLetterDict.put("--.-", "Q");
        morseToLetterDict.put(".-.", "R");
        morseToLetterDict.put("...", "S");
        morseToLetterDict.put("-", "T");
        morseToLetterDict.put("..-", "U");
        morseToLetterDict.put("...-", "V");
        morseToLetterDict.put(".--", "W");
        morseToLetterDict.put("-..-", "X");
        morseToLetterDict.put("-.--", "Y");
        morseToLetterDict.put("--..", "Z");
        morseToLetterDict.put("-----", "0");
        morseToLetterDict.put(".----", "1");
        morseToLetterDict.put("..---", "2");
        morseToLetterDict.put("...--", "3");
        morseToLetterDict.put("....-", "4");
        morseToLetterDict.put(".....", "5");
        morseToLetterDict.put("-....", "6");
        morseToLetterDict.put("--...", "7");
        morseToLetterDict.put("---..", "8");
        morseToLetterDict.put("----.", "9");
        morseToLetterDict.put(".-.-.-", ".");
        morseToLetterDict.put("--..--", ",");
        morseToLetterDict.put("..--..", "?");
        morseToLetterDict.put(".----.", "'");
        morseToLetterDict.put("-.-.--", "!");
        morseToLetterDict.put("...---...", "SOS");
        morseToLetterDict.put("whitespace", " ");
    }


    public static String decodeBits(String bits) {
        String formattedBitString = bits.trim().replaceAll("^0*|0*$", "");

        int[][] boundariesZero = determineCharBoundaries('0', formattedBitString);
        int[][] boundariesOne = determineCharBoundaries('1', formattedBitString);

        String dashPattern = String.format("(?<!1)[1]{%d,%d}(?!1)", boundariesOne[1][0], boundariesOne[1][1]);
        String dotPattern = String.format("(?<!1)[1]{%d,%d}(?!1)", boundariesOne[0][0], boundariesOne[0][1]);
        String wordSpacePattern = String.format("(?<!0)[0]{%d,%d}(?!0)", boundariesZero[2][0], boundariesZero[2][1]);
        String letterSpacePattern = String.format("(?<!0)[0]{%d,%d}(?!0)", boundariesZero[1][0], boundariesZero[1][1]);
        String morseCharSpaceSpacePattern = String.format("(?<!0)[0]{%d,%d}(?!0)", boundariesZero[0][0], boundariesZero[0][1]);

        formattedBitString = formattedBitString.replaceAll(dashPattern, "-");
        formattedBitString = formattedBitString.replaceAll(dotPattern, ".");
        formattedBitString = formattedBitString.replaceAll(wordSpacePattern, "   ");
        formattedBitString = formattedBitString.replaceAll(letterSpacePattern, " ");
        formattedBitString = formattedBitString.replaceAll(morseCharSpaceSpacePattern, "");

        return formattedBitString;
    }

    private static int[][] determineCharBoundaries(char ch, String formattedBitString) {
        String charString = "(" + ch + "+)";
        Pattern charPattern = Pattern.compile(charString);
        Matcher groupCharMatcher = charPattern.matcher(formattedBitString);
        List<String> charStringList = new ArrayList<>();
        while (groupCharMatcher.find()) {
            charStringList.add(groupCharMatcher.group(1));
        }

        int k = 0;
        if (ch == '0') k = 3;
        else if (ch == '1') k = 2;

        int[][] result = kClustering(charStringList, k);
        return result;
    }

    public static String decodeMorse(String morseCode) {
        return Arrays
                .stream(morseCode.split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(MorseCodeDecoderThree::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

    private static int[][] kClustering(List<String> charList, int k) {
        int[][] result = new int[k][2];
        if (charList.isEmpty()) {
            for (int i = 0; i < k; i++) {
                Arrays.fill(result[i], 0);
            }
            return result;
        }
        List<Integer> data = charList
                .stream()
                .map(String::length)
                .sorted()
                .collect(Collectors.toList());

        int totalNumberOfCharSequences = charList.size();
        double[] centroids = new double[k];
        List<Integer>[] groups = new List[k];
        List<Integer>[] tempGroups = new List[k];

        // set initial values
        for (int i = 0; i < k; i++) {
            centroids[i] = data.get(i * ((totalNumberOfCharSequences - 1) / (k - 1))) + i;
            List<Integer> group = new ArrayList<>(data.subList(i * totalNumberOfCharSequences / k, (i + 1) * totalNumberOfCharSequences / k));
            groups[i] = group;
            List<Integer> tempGroup = new ArrayList<>();
            tempGroups[i] = tempGroup;
        }

        // running clustering
        boolean finished = false;
        while (!finished) {
            finished = true;
            for (int record : data) {
                double[] distances = new double[k];
                for (int i = 0; i < k; i++) {
                    distances[i] = Math.abs(record - centroids[i]);
                }
                double smallestDist = Arrays.stream(distances).min().getAsDouble();
                for (int i = 0; i < k; i++) {
                    if (distances[i] == smallestDist) tempGroups[i].add(record);
                }
            }

            for (int i = 0; i < k; i++) {
                if (!groups[i].equals(tempGroups[i])) finished = false;
            }

            if (!finished) {
                for (int i = 0; i < k; i++) {
                    groups[i].clear();
                    groups[i].addAll(tempGroups[i]);

                    centroids[i] = (double) groups[i]
                            .stream()
                            .reduce(0, (a, b) -> a + b) / groups[i].size();

                    tempGroups[i].clear();
                }
            } else {
                for (int i = 0; i < k; i++) {
                    result[i][0] = groups[i].get(0);
                    result[i][1] = groups[i].get(groups[i].size() - 1);
                }
            }
        }
        return result;
    }

    private static String get(String morseLetter) {
        return morseToLetterDict.get(morseLetter);
    }

}
