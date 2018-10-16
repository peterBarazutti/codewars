package two_kyu;


import java.math.BigDecimal;
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

        if (formattedBitString.length() == 0) return "";

        int[][] boundaries = determineCharBoundaries(formattedBitString);


        String dashPattern = String.format("(?<!1)[1+]{%d,%d}(?!1)", boundaries[1][0], boundaries[2][1]);
        String dotPattern = String.format("(?<!1)[1+]{%d,%d}(?!1)", boundaries[0][0], boundaries[0][1]);
        String wordSpacePattern = String.format("(?<!0)[0+]{%d,%d}(?!0)", boundaries[2][0], boundaries[2][1]);
        String letterSpacePattern = String.format("(?<!0)[0+]{%d,%d}(?!0)", boundaries[1][0], boundaries[1][1]);
        String morseCharSpaceSpacePattern = String.format("(?<!0)[0+]{%d,%d}(?!0)", boundaries[0][0], boundaries[0][1]);

        formattedBitString = formattedBitString.replaceAll(dashPattern, "-");
        formattedBitString = formattedBitString.replaceAll(dotPattern, ".");
        formattedBitString = formattedBitString.replaceAll(wordSpacePattern, "   ");
        formattedBitString = formattedBitString.replaceAll(letterSpacePattern, " ");
        formattedBitString = formattedBitString.replaceAll(morseCharSpaceSpacePattern, "");

        return formattedBitString;
    }

    private static int[][] determineCharBoundaries(String formattedBitString) {
        List<String> charStringList = new ArrayList<>();
        String charZeroString = "(0+)";
        Pattern charZeroPattern = Pattern.compile(charZeroString);
        Matcher groupZeroCharMatcher = charZeroPattern.matcher(formattedBitString);
        while (groupZeroCharMatcher.find()) {
            charStringList.add(groupZeroCharMatcher.group(1));
        }
        String charOneString = "(1+)";
        Pattern charOnePattern = Pattern.compile(charOneString);
        Matcher groupOneCharMatcher = charOnePattern.matcher(formattedBitString);
        while (groupOneCharMatcher.find()) {
            charStringList.add(groupOneCharMatcher.group(1));
        }

        int[][] result = kClustering(charStringList, 3);
        return result;
    }

    public static String decodeMorse(String morseCode) {
        if (morseCode.length() == 0) return "";
        return Arrays
                .stream(morseCode.split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(MorseCodeDecoderThree::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

    private static int[][] kClustering(List<String> charList, int k) {
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Arrays.fill(result[i], 1000);
        }
        List<Integer> data = charList
                .stream()
                .map(String::length)
                .map(Double::valueOf)
                .map(num -> Math.pow(num, 2d))
                .sorted()
                .mapToInt(Double::intValue)
                .boxed()
                .collect(Collectors.toList());

        int[] expectedLength = {1, 9, 49};
        int initialCentroid = data
                .stream()
                .min(Integer::compareTo)
                .orElse(1);

        BigDecimal[] centroids = new BigDecimal[k];
        List<Integer>[] groups = new List[k];
        List<Integer>[] tempGroups = new List[k];


        // set initial values
        for (int i = 0; i < k; i++) {
            centroids[i] = BigDecimal.valueOf(initialCentroid)
                    .multiply(BigDecimal.valueOf(expectedLength[i]));
            List<Integer> group = new ArrayList<>();
            groups[i] = group;

            List<Integer> tempGroup = new ArrayList<>();
            tempGroups[i] = tempGroup;
        }

        groups[0] = data.stream().filter(num -> num >= 1 && num < 2 * initialCentroid).collect(Collectors.toList());
        groups[1] = data.stream().filter(num -> num >= 2 * initialCentroid && num < 6 * initialCentroid).collect(Collectors.toList());
        groups[2] = data.stream().filter(num -> num >= 6 * initialCentroid).collect(Collectors.toList());

        // running clustering
        boolean finished = false;
        while (!finished) {
            finished = true;
            for (int record : data) {
                BigDecimal[] distances = new BigDecimal[k];
                for (int i = 0; i < k; i++) {
                    distances[i] = BigDecimal.valueOf(record).subtract(centroids[i]).abs();
                }
                BigDecimal smallestDist = Arrays
                        .stream(distances)
                        .min(BigDecimal::compareTo)
                        .get();
                for (int i = 0; i < k; i++) {
                    if (distances[i].equals(smallestDist)) tempGroups[i].add(record);
                }
            }

            for (int i = 0; i < k; i++) {
                if (!groups[i].equals(tempGroups[i])) finished = false;
            }

            if (!finished) {
                for (int i = 0; i < k; i++) {
                    groups[i].clear();
                    groups[i].addAll(tempGroups[i]);

                    if (groups[i].size() != 0) {
                        centroids[i] = groups[i]
                                .stream()
                                .map(BigDecimal::valueOf)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                                .divide(BigDecimal.valueOf(groups[i].size()), 2, BigDecimal.ROUND_DOWN);
                    }
                    tempGroups[i].clear();
                }
            } else {
                for (int i = 0; i < k; i++) {
                    if (groups[i].size() != 0) {
                        result[i][0] = (int) Math.sqrt(groups[i].get(0));
                        result[i][1] = (int) Math.sqrt(groups[i].get(groups[i].size() - 1)) + 1;
                    }
                }
            }
        }
        return result;
    }

    private static String get(String morseLetter) {
        return morseToLetterDict.get(morseLetter);
    }

}
