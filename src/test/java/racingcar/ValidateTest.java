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

    @Test
    void testAttemptsNegative() {
        String input = "-3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validate.attempts(input);
        });
        assertEquals("숫자는 양의 정수여야 합니다.", exception.getMessage());
    }

    @Test
    void testAttemptsInvalidFormat() {
        String input = "!@#ㅃ";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validate.attempts(input);
        });
        assertEquals("유효한 숫자가 아닙니다.", exception.getMessage());
    }

    @Test
    void testCarNameTooLong() {
        String input = "Tom,Jake,Michael";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validate.carName(input);
        });
        assertEquals("자동차 이름은 5자 이하여야 합니다: Michael", exception.getMessage());
    }
}
