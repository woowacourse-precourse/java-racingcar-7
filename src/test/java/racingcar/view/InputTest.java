package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputTest {
    @Test
    public void testIsInteger() {
        assertTrue(Input.isInteger("123"));
        assertTrue(Input.isInteger("0"));
        assertFalse(Input.isInteger("abc"));
        assertFalse(Input.isInteger("12.34"));
        assertFalse(Input.isInteger(""));
    }

    @Test
    public void testIsNameShorterThan5() {
        assertTrue(Input.isNameShorterThan5("car"));
        assertTrue(Input.isNameShorterThan5("12345"));
        assertFalse(Input.isNameShorterThan5("123456"));
    }

    @Test
    public void testInputGameNumber() {
        String input = "3";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));  // 입력을 시뮬레이션

        int gameNumber = Input.inputGameNumber();
        assertEquals(3, gameNumber);
    }
}