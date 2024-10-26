package racingcar.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    @DisplayName("빈 문자열 예외")
    public void testEmptyNumberString() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidator.validateNumberString("")
        );
    }

    @Test
    @DisplayName("숫자가 아니면 예외")
    public void testIsNotNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidator.validateNumberString("a")
        );
    }

    @Test
    @DisplayName("양의 정수가 아니면 예외")
    public void testIsNotPositiveInteger() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidator.validateNumberString("-1")
        );
    }

    @Test
    @DisplayName("숫자가 11이상이면 예외")
    public void testIsBiggerThenTen() {
        assertThrows(IllegalArgumentException.class, () ->
                NumberValidator.validateNumberString("11")
        );
    }
}
