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
        assertThrows(IllegalArgumentException.class, () -> Application.validateAttemptCount(input));
    }

    @Test
    @DisplayName("공백이 포함된 경우 예외 발생")
    void testInputWithWhitespace() {
        String input = " 10 ";
        assertThrows(IllegalArgumentException.class, () -> Application.validateAttemptCount(input));
    }

    @Test
    @DisplayName("정수가 아닌 값이 입력된 경우 예외 발생")
    void testNonIntegerInput() {
        String input = "abc";
        assertThrows(IllegalArgumentException.class, () -> Application.validateAttemptCount(input));
    }

    @Test
    @DisplayName("0 이하의 값이 입력된 경우 예외 발생")
    void testNonPositiveIntegerInput() {
        String input = "0";
        assertThrows(IllegalArgumentException.class, () -> Application.validateAttemptCount(input));
    }


}
