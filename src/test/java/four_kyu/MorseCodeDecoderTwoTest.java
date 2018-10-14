package four_kyu;

import org.junit.Test;
import six_kyu.MorseCodeDecoder;

import static org.junit.Assert.*;

public class MorseCodeDecoderTwoTest {


    @Test
    public void testReplaceDots() {
        assertEquals("..", MorseCodeDecoderTwo.decodeBits("001100110"));
    }

    @Test
    public void testReplaceDashes() {
        assertEquals(".--", MorseCodeDecoderTwo.decodeBits("00110011111100111111"));
    }

    @Test
    public void testDecodeMorse() {
        assertEquals("HEY JUDE", MorseCodeDecoderTwo.decodeMorse(".... . -.--   .--- ..- -.. ."));
    }

    @Test
    public void testDecodeBits() {
        assertEquals(".... . -.--   .--- ..- -.. .", MorseCodeDecoderTwo.decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"));
    }

    @Test
    public void testReturnM() {
        assertEquals("--", MorseCodeDecoderTwo.decodeBits("1110111"));
    }
}