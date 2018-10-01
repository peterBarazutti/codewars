package five_kyu.testFive;

import five_kyu.RemovedNumbers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class RemovedNumbersTest {

    RemovedNumbers rn;

    @Before
    public void initClass(){
        rn = new RemovedNumbers();
    }

    @Test
    public void removedNb(){
        List<long[]> testList = new ArrayList<>();
        testList.add(new long[]{15,21});
        testList.add(new long[]{21,15});
        assertArrayEquals(testList.get(0), rn.removeNb(26).get(0));
        assertArrayEquals(testList.get(1), rn.removeNb(26).get(1));
    }

}