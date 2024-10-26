package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidTest {

    Valid valid = new Valid();

    @Test
    void testValidUserInput_withValidNames() {
        String input = "Car1,Race2,Fast3";
        List<String> result = valid.validCarsName(input);
        assertEquals(3, result.size(), "There should be three valid names");
        assertEquals("Car1", result.get(0));
        assertEquals("Race2", result.get(1));
        assertEquals("Fast3", result.get(2));
    }

    @Test
    void testValidUserInput_withEmptyInput() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> valid.validCarsName(input));
    }

    @Test
    void testValidUserInput_withBlankName() {
        String input = "Car1,,Race2";
        assertThrows(IllegalArgumentException.class, () -> valid.validCarsName(input));
    }

    @Test
    void testValidUserInput_withNameExceedingFiveCharacters() {
        String input = "Car123,Fast";
        assertThrows(IllegalArgumentException.class, () -> valid.validCarsName(input));
    }

    @Test
    void testValidUserInput_withInvalidCharacters() {
        String input = "Car1,Fast!";
        assertThrows(IllegalArgumentException.class, () -> valid.validCarsName(input));
    }

    @Test
    void testValidRoundTime_withValidInput() {
        String input = "5";
        int result = valid.validRoundTime(input);
        assertEquals(5, result);
    }

    @Test
    void testValidRoundTime_withInvalidInput() {
        //given
        String input = "abc";
        //when, then
        assertThrows(IllegalArgumentException.class, () -> valid.validRoundTime(input));
    }
}