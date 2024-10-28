package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountValidationTest {

    @Test
    @DisplayName("빈 문자열이 입력된 경우 예외 발생")
    void testEmptyInput() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> AttemptValidator.validate(input));
    }

    @Test
    @DisplayName("공백이 포함된 경우 예외 발생")
    void testInputWithWhitespace() {
        String input = " 10 ";
        assertThrows(IllegalArgumentException.class, () -> AttemptValidator.validate(input));
    }

    @Test
    @DisplayName("정수가 아닌 값이 입력된 경우 예외 발생")
    void testNonIntegerInput() {
        String input = "abc";
        assertThrows(IllegalArgumentException.class, () -> AttemptValidator.validate(input));
    }

    @Test
    @DisplayName("0이 입력된 경우 예외 발생")
    void testZeroInput() {
        String input = "0";
        assertThrows(IllegalArgumentException.class, () -> AttemptValidator.validate(input));
    }

    @Test
    @DisplayName("음수 입력 시 예외 발생")
    void testNegativeIntegerInput() {
        String input = "-5";
        assertThrows(IllegalArgumentException.class, () -> AttemptValidator.validate(input));
    }

    @Test
    @DisplayName("올바른 양의 정수 입력 시 정상적으로 시도 횟수를 반환")
    void testValidPositiveIntegerInput() {
        String input = "3";
        int result = AttemptValidator.validate(input);
        assertEquals(3, result);
    }
}
