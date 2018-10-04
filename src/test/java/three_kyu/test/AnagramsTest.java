package three_kyu.test;

import org.junit.Before;
import org.junit.Test;
import three_kyu.Anagrams;

import static org.junit.Assert.*;

public class AnagramsTest {

    Anagrams ang;

    @Before
    public void initClass() {
        ang = new Anagrams();
    }

    @Test
    public void calcFactorialValidNotZeroInput(){
        assertEquals(6, ang.calcFactorial(3));
        assertEquals(120, ang.calcFactorial(5));
        assertEquals(40320, ang.calcFactorial(8));
    }

    @Test
    public void calcFactorialZeroInput() {
        assertEquals(1, ang.calcFactorial(0));
    }

}