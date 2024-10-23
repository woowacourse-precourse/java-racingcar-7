package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}