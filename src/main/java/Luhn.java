import java.util.stream.IntStream;

public class Luhn {

    public boolean validate(String n) {
        String[] strArray = n.split("");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        for (int i = intArray.length-2; i >= 0; i-=2) {
            int modNumber = intArray[i]*2;
            if (modNumber > 9) modNumber = modNumber - 9;
            intArray[i] = modNumber;
        }
        int sum = IntStream.of(intArray).sum();
        return sum%10==0? true:false;

    }
}
