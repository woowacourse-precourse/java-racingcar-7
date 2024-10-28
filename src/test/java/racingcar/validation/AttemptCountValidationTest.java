package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.ErrorMessage.ATTEMPT_COUNT_CANNOT_BE_NULL_OR_EMPTY;
import static racingcar.constant.ErrorMessage.ATTEMPT_COUNT_IS_NOT_AN_INTEGER;

class AttemptCountValidationTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("시도할 횟수가 null 이거나 빈 값일 수 없다.")
    void validateNotNullOrEmptyTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(ATTEMPT_COUNT_CANNOT_BE_NULL_OR_EMPTY.getMessage(), exception.getMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc"})
    @DisplayName("시도할 횟수는 정수여야 한다.")
    void validateIsIntegerTest(String input) {
        Throwable exception = getValidate(input);
        assertEquals(ATTEMPT_COUNT_IS_NOT_AN_INTEGER.getMessage(), exception.getMessage());

    }

    private Throwable getValidate(String input) {
        return assertThrows(IllegalArgumentException.class, () -> {
            AttemptCountValidation.validate(input);
        });
    }
}