package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidateTest {
    @Test
    void testCarNameStartOrEndComma() {
        String input = ",Tom,Jake";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validate.carName(input);
        });
        assertEquals("자동차 이름의 시작이나 끝에 콤마가 올 수 없습니다.", exception.getMessage());
    }

    @Test
    void testCarNameEmpty() {
        String input = "Tom,,Jake";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validate.carName(input);
        });
        assertEquals("자동차 이름이 비어있습니다.", exception.getMessage());
    }
}
