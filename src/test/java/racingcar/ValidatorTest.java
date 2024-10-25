package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.exception.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void validateNameLength() {
        //given
        String name1 = "hello";
        String name2 = "racingcar";
        //when //then
        assertEquals("hello", Validator.validateNameLength(name1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameLength(name2));
    }
    @Test
    void validateCountIfNegative() {
        //given
        String count1 = "5";
        String count2 = "-5";
        //when //then
        assertEquals(5, Validator.validateCountIfNegative(count1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCountIfNegative(count2));
    }
}