package two_kyu;

import org.junit.Test;

import static org.junit.Assert.*;

public class MorseCodeDecoderThreeTest {

    @Test
    public void testHeyJudeBitsToMorse() {
        assertEquals(".... . -.--   .--- ..- -.. .", MorseCodeDecoderThree.decodeBits("00000000110110100111000001100000011111101001111100111111000000000001110111111110111110111110000001011000" +
                "11111100000111110011101100000100000"));
    }

    @Test
    public void testBrownFoxBitsToMorse() {
        assertEquals("- .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --.", MorseCodeDecoderThree.decodeBits(
                "111110000001100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011\n" +
                "0000000000011111110000001101000111011100000000111000000000000000000111111101111110000110111110000011110011110001111110000000101110000001111111001000111110011000001111110010111110000000000000011111" +
                "110000111101011000001100011111001000001111111000111111001111111000001000111111000111111110000000111111110111000000000000001011000011111111011110000011111011111001111111000000001111100101101111100000" +
                "000000011101111101111101111100000001000100111110000011111011111111000000111001111110001111101000000110000100100000000000000000011111111001111101111110000001000100100001111100000010000000010111110100" +
                "000000000001111110000001111010000100110000000000111000000000000000110111110111100010000010000111111111000000000111111001111110001110110000011111100001101111100011111100000000000000000111111000010011" +
                "0000011111101111111011111111100000001111110001111100001000000000000000000000000000000000000000000000000000000000000"));
    }

    @Test
    public void decodeMorse() {
        assertEquals("HEY JUDE", MorseCodeDecoderThree.decodeMorse(".... . -.--   .--- ..- -.. ." ));
    }
}