package four_kyu;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// http://www.codewars.com/kata/decode-the-morse-code-advanced/train/java
public class MorseCodeDecoderTwo {

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

        Integer shortestZeroStringLength = determineShortestCharSeqLength('0', formattedBitString);;
        Integer shortestOneStringLength = determineShortestCharSeqLength('1', formattedBitString);;

        int sampleTime = (shortestZeroStringLength < shortestOneStringLength) ? shortestZeroStringLength : shortestOneStringLength;

        formattedBitString = formattedBitString.replaceAll("[1]{" + sampleTime * 3 + "}", "-");
        formattedBitString = formattedBitString.replaceAll("[1]{" + sampleTime + "}", ".");
        formattedBitString = formattedBitString.replaceAll("[0]{" + sampleTime * 7 + "}", "   ");
        formattedBitString = formattedBitString.replaceAll("[0]{" + sampleTime * 3 + "}", " ");
        formattedBitString = formattedBitString.replaceAll("[0]{" + sampleTime + "}", "");

        return formattedBitString;
    }

    private static Integer determineShortestCharSeqLength(char ch, String formattedBitString) {
        String charString = "("+ ch +"+)";
        Pattern charPattern = Pattern.compile(charString);
        Matcher groupCharMatcher = charPattern.matcher(formattedBitString);
        List<String> charStrings = new ArrayList<>();
        while (groupCharMatcher.find()) {
            charStrings.add(groupCharMatcher.group(1));
        }
        return charStrings
                .stream()
                .map(String::length)
                .min(Integer::compareTo)
                .orElse(100);
    }

    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(MorseCodeDecoderTwo::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

    private static String get(String morseLetter) {
        return morseToLetterDict.get(morseLetter);
    }

}
