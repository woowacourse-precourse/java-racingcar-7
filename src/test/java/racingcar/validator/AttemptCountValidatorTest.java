package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class AttemptCountValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("올바른 값 입력 시 정상 통과")
    void testSuccessValidInput() {
        String input = "10";
        assertDoesNotThrow(() -> inputValidator.validateAttemptCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("횟수 입력값이 공백일 경우 예외 발생")
    void testCountIsEmpty(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateIsEmpty(input));

        assertEquals("입력값은 공백이 아니어야 합니다.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"5"})
    @DisplayName("횟수 입력값이 공백이 아닐 경우 정상 통과")
    void testCountIsNotEmpty(String input) {
        assertDoesNotThrow(() -> inputValidator.validateIsEmpty(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"*"})
    @DisplayName("횟수 입력값이 숫자가 아닐경우 예외 발생")
    void testInvalidAttemptCount(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateAttemptCount(input));

        assertEquals("입력된 시도 횟수는 숫자여야 합니다.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2.5"})
    @DisplayName("입력된 숫자가 소수일때 예외 발생")
    void testNotInteger(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateAttemptCount(input));

        assertEquals("입력된 시도 횟수는 숫자여야 합니다.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1"}) //given
    @DisplayName("입력된 음수일때 예외 발생")
    void testNegativeNumber(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateAttemptCount(input));

        assertEquals("입력된 숫자는 양수여야 합니다.", thrown.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"9223372036854775807"}) //given
    @DisplayName("정수범위 초과 입력시 예외 발생")
    void testOverFlowInteger(String input) {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateAttemptCount(input));

        assertEquals("입력된 숫자가 정수의 최대 범위를 초과합니다.", thrown.getMessage());
    }
}
