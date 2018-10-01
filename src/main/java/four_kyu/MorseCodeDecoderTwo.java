package four_kyu;

import java.util.*;
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
        bits = trimNoise(bits);
        int sampleTime = getSampleTime(bits);
        return bits
                .replaceAll("[1]{" + (sampleTime + 1) + ",}", "-")
                .replaceAll("[1]{" + sampleTime + "}", ".")
                .replaceAll("[0]{"+ (sampleTime * 6) +",}","   ")
                .replaceAll("[0]{"+ (sampleTime * 3) +"}"," ")
                .replaceAll("[0]{"+ sampleTime +"}","");
    }

    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(MorseCodeDecoderTwo::get)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }



    /*private static int getSampleTime(String bits) {
        if (bits.split("0").length == 1){
            return trimNoise(bits).length();
        }
        int sampleTime = Arrays.stream(bits.split("0"))
                .max((word1, word2) -> {
                    if (word1.length() > word2.length()) return 1;
                    else if (word1.length() < word2.length()) return -1;
                    else return 0;
                })
                .get()
                .length() / 3;
        return sampleTime;
    }
*/

    private static int getSampleTime(String bits) {
        return Arrays.stream(trimNoise(bits).split("[0]{1,}"))
                .map(symbol -> symbol.length())
                .min((symbol1, symbol2) -> {
                    if (symbol1 > symbol2) return 1;
                    if (symbol1 < symbol2) return -1;
                    else return 0;
                })
                .get();
    }

    private static String trimNoise(String bits) {
        List<String> temp = new ArrayList<>(Arrays.asList(bits.split("")));
        Integer firstIndex = temp.indexOf("1");
        Integer lastIndex = temp.lastIndexOf("1");
        temp = temp.subList(firstIndex, lastIndex + 1);
        return temp.stream().collect(Collectors.joining(""));
    }

    private static String get(String morseLetter) {
        return morseToLetterDict.get(morseLetter);
    }

}
