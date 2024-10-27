package racingcar.count;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountInputValidatorTest {
    private CountInputValidator countInputValidator;

    @BeforeEach
    void setup() {
        countInputValidator = new CountInputValidator();
    }

    @Test
    @DisplayName("시도 횟수 입력값이 비어있을 때 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenAttemptCountIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                countInputValidator.checkIsAttemptCountValid("")
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_EMPTY.getMessage()));
    }

    @Test
    @DisplayName("시도 횟수에 20보다 큰 수가 입력되었을 때 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenAttemptCountIsZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                countInputValidator.checkIsAttemptCountValid("22")
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_INVALID.getMessage()));
    }

    @Test
    @DisplayName("시도 횟수가 0이하의 입력되었을 때 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenAttemptCountIsSmallThanZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                countInputValidator.checkIsAttemptCountValid("-1")
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_INVALID.getMessage()));
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 문자가 입력되는 경우 예외가 발생해야 한다.")
    void shouldThrowExceptionWhenAttemptCountIsNotANumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                countInputValidator.checkIsAttemptCountValid("abc")
        );

        assert (exception.getMessage().contains(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_NOT_A_NUMBER.getMessage()));
    }

    @Test
    @DisplayName("시도 횟수가 모든 조건을 만족할 때는 예외가 발생하지 않아야 한다.")
    void shouldNotThrowExceptionForValidAttemptCount() {
        assertDoesNotThrow(() -> countInputValidator.checkIsAttemptCountValid("1"));
        assertDoesNotThrow(() -> countInputValidator.checkIsAttemptCountValid("5"));
        assertDoesNotThrow(() -> countInputValidator.checkIsAttemptCountValid("20"));
    }
}