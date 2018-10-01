import four_kyu.DoubleLinear;
import javaBasics.GenClass;

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

        GenClass<String, String> g1 = new GenClass<>("A", "Value A");
        System.out.println("Key- " + g1.getKey());
        System.out.println("Value- " + g1.getValue());

        GenClass<Integer, String> g2 = new GenClass<>(1, "Value 1");
        System.out.println("Key- " + g2.getKey());
        System.out.println("Value- " + g2.getValue());

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
        DoubleLinear dl = new DoubleLinear();
        dl.dblLinear(10);
    }


    public static double sumOfElements(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
}
