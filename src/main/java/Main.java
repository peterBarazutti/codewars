import four_kyu.DoubleLinear;
import four_kyu.Funnel;
import four_kyu.MorseCodeDecoderTwo;
import four_kyu.Snail;
import three_kyu.*;
import two_kyu.MorseCodeDecoderThree;

import java.awt.*;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {

    public Main() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        //Main mn = new Main();
        /*GrandChild gc = new GrandChild();
        EnumSet<CELL_VALUE> eset = EnumSet.range(CELL_VALUE.BOMB, CELL_VALUE.FOUR);
        Vector<String> vec = new Vector<>();
        System.out.println(eset);*/


        /*String text    =
                "This is the text to be searched " +
                        "for occurrences of the http:// pattern.";

        String patternString = ".*http://.*";

        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);

        boolean matches = matcher.matches();

        System.out.println("matches = " + matches);*/


        //BestTravel
        /*List<Integer> tl1 = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        List<Integer> tl2 = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        List<Integer> tl3 = new ArrayList<>(Arrays.asList(50));
        List<Integer> tl4 = new ArrayList<>(Arrays.asList(100, 76, 56, 44, 89, 73, 68, 56, 64, 123, 2333, 144, 50, 132, 123, 34, 89));
        System.out.println(BestTravel.chooseBestSum(230, 3, tl2));*/

        //We are family
        /*WeAreFamily fam = new WeAreFamily();
        System.out.println(fam.setParentOf("Vera", "George"));
        System.out.println(fam.setParentOf("Vera", "Vanessa"));
        System.out.println(fam.female("Vanessa"));
        System.out.println(fam.female("George"));
        fam.isMale("George");*/
        /*Decompose dec = new Decompose();
        System.out.println(dec.decompose(11));*/

/*        ChildClass cc = new ChildClass();
        ParentClass pc = new ParentClass();*/

        /*
        System.out.println(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
        String heyjude01 = "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
        String morseCode = MorseCodeDecoderTwo.decodeBits("110011");
        System.out.println(MorseCodeDecoderTwo.decodeMorse(morseCode));*/
        /*String ad = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432,"
                + "54 Holy Grail Street Niagara Town ZP 32908,3200 Main Rd. Bern AE 56210,1 Gordon St. Atlanta RE 13000,"
                + "10 Pussy Cat Rd. Chicago EX 34342,10 Gordon St. Atlanta RE 13000,58 Gordon Road Atlanta RE 13000,"
                + "22 Tokyo Av. Tedmondville SW 43098,674 Paris bd. Abbeville AA 45521,10 Surta Alley Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32908,320 Main Al. Bern AE 56210,14 Gordon Park Atlanta RE 13000,"
                + "100 Pussy Cat Rd. Chicago EX 34342,2 Gordon St. Atlanta RE 13000,5 Gordon Road Atlanta RE 13000,"
                + "2200 Tokyo Av. Tedmondville SW 43098,67 Paris St. Abbeville AA 45521,11 Surta Avenue Goodtown GG 30654,"
                + "45 Holy Grail Al. Niagara Town ZP 32918,320 Main Al. Bern AE 56215,14 Gordon Park Atlanta RE 13200,"
                + "100 Pussy Cat Rd. Chicago EX 34345,2 Gordon St. Atlanta RE 13222,5 Gordon Road Atlanta RE 13001,"
                + "2200 Tokyo Av. Tedmondville SW 43198,67 Paris St. Abbeville AA 45522,11 Surta Avenue Goodville GG 30655,"
                + "2222 Tokyo Av. Tedmondville SW 43198,670 Paris St. Abbeville AA 45522,114 Surta Avenue Goodville GG 30655,"
                + "2 Holy Grail Street Niagara Town ZP 32908,3 Main Rd. Bern AE 56210,77 Gordon St. Atlanta RE 13000";
        String r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432";
        System.out.println(Travel.travel(ad, "OH 43071"));
        String[] testArr = {"default", "also default"};
        Main m = new Main();
        System.out.println(testArr[0]);
        m.mod(testArr);
        System.out.println(testArr[0]);*/

     /*   // With List<Integer>
        List<Integer> li = Arrays.asList(5, 6, 7);
        System.out.println("sum = " + sumOfElements(li));
        // With List<Double>
        List<Double> ld = Arrays.asList(1.2, 3.8, 8.2);
        System.out.println("sum = " + sumOfElements(ld));
*/
        /*Snail sn = new Snail();
        System.out.println(sn.snail(new int[][]
                {
                        {1, 2, 3, 9},
                        {4, 5, 6, 4},
                        {7, 8, 9, 1},
                        {1, 2, 3, 4}
                }));
        int[] arr1 = {1};
        int[] arr2 = {1};
        System.out.println(arr1 == arr2);*/
       /* List<String> letterList = new ArrayList<>(Arrays.asList("q","u","e","s","t","i","o","n"));
        letterList.sort(String::compareTo);
        System.out.println(letterList);

        List<String> letterList2 = new ArrayList<>(Arrays.asList("A","A","B","C","C"));


        Anagrams an = new Anagrams();
        System.out.println(an.listPosition("QUESTION"));
        //an.findAllWords(Arrays.asList("I","O","S"));
        Spiralizor sp = new Spiralizor();
        sp.spiralize(5);
        BigInteger a = BigInteger.valueOf(5);
        BigInteger temp = a;
        System.out.println(a);
        System.out.println(temp);
        a = BigInteger.valueOf(1);
        System.out.println(a);
        System.out.println(temp);
        System.out.println("FIBO");
        System.out.println(Fibonacci.fib(BigInteger.valueOf(1_375_906)));
        BigInteger asd = new BigInteger("123");*/


/*        System.out.println(MorseCodeDecoderTwo.decodeMorse(".... . -.--   .--- ..- -.. ."));
        System.out.println(MorseCodeDecoderTwo.decodeMorse("."));
        System.out.println(MorseCodeDecoderTwo.decodeBits("110"));
        System.out.println(MorseCodeDecoderTwo.decodeBits("110011"));
        System.out.println(MorseCodeDecoderTwo.decodeBits("1100111111"));
        System.out.println(MorseCodeDecoderTwo.decodeBits("11111100111111"));
        System.out.println(MorseCodeDecoderTwo.decodeBits("10001"));*/



/*        System.out.println();
        List<Integer> test0 = Arrays.asList(1,1);
        List<Integer> test1 = Arrays.asList(1,1);
        System.out.println(test0.equals(test1));

        String strExp = "asd";
        System.out.println(strExp);
        System.out.println(strExp.concat("a"));
        System.out.println(strExp);
        strExp = strExp.concat("DONT TAKE THE MOOOONEY");
        System.out.println(strExp);
        System.out.println(Double.compare(0d, Math.cos(Math.PI/2)));
        RailFenceCipher rfc = new RailFenceCipher();
        System.out.println(RailFenceCipher.encode("WEAREDISCOVEREDFLEEATONCE", 8));
        System.out.println(RailFenceCipher.encode("Hello, World!", 4));
        System.out.println(RailFenceCipher.encode("", 3));
        System.out.println(RailFenceCipher.decode("WCLEESOFECAIVDENRDEEAOERT", 5));
        System.out.println(RailFenceCipher.decode("", 5));
        System.out.println(RailFenceCipher.decode("H !e,Wdloollr", 4));*/
/*        String encodedString = RailFenceCipher.encode("WEAREDISCOVEREDFLEEATONCE", 4);
        System.out.println(encodedString);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(RailFenceCipher.decode(encodedString, 4));
        System.out.println(RailFenceCipher.decode(RailFenceCipher.encode("vmi random szoveg", 4), 4));*/
/*        System.out.println(Calculator.evaluate("2 / 2 + 6 * 8 * 9"));
        System.out.println(Calculator.evaluate("-1097152535 + -1611138461"));
        System.out.println(Calculator.evaluate("-1097152535 - -1611138461 - 273039584"));*/
        //System.out.println(Calculator.evaluate("(3+(5+ (3+4) + (6+10)))+ (1 + 1)"));

        String decodedBits = MorseCodeDecoderThree.decodeBits("0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000");
        String decodedBits3 = MorseCodeDecoderThree.decodeBits("1");
        String decodedBits2 = MorseCodeDecoderThree.decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011");
        System.out.println(decodedBits3);
        String decodedMessage = MorseCodeDecoderThree.decodeMorse(decodedBits3);
        System.out.println(decodedMessage);
    }

}
