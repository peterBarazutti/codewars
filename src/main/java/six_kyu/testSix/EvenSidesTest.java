package six_kyu.testSix;

import org.junit.Before;
import org.junit.Test;
import six_kyu.EvenSides;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class EvenSidesTest {

    EvenSides es;

    @Before
    public void initClass(){
        es = new EvenSides();
    }

    @Test
    public void findBiggerThanZeroIndex(){
        assertEquals(3, es.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
    }

    @Test
    public void findZeroIndex(){
        assertEquals(0, es.findEvenIndex(new int[] {20,10,-80,10,10,15,35}));
    }

    @Test
    public void noPossibleSolution() {
        assertEquals(-1, es.findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
    }

}