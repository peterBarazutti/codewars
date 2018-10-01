package one_kyu.minesweeper.test;

import one_kyu.minesweeper.src.Minesweeper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MinesweeperTest {

    Minesweeper ms;

    @Before
    public void beforeTests() {
        ms = new Minesweeper();
    }

    @Test
    public void inputMapProcessorTest() {
        assertEquals(new String[][] {{"0", "?"}, {"1","1"}, {"x", "0"}},
                ms.processInputMap("0 ?\n1 1\nx 0"));
    }

}