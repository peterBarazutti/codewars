package javaBasics;

import java.util.stream.IntStream;

public class StreamClass {

    public void fosPumpa() {
        for (int i = 0; i < 10; i++) {
            System.out.println(calcSum(i));

        }
    }

    private int calcSum(int i) {
        return IntStream.rangeClosed(0,10).filter(num -> num != i).sum();
    }

}
