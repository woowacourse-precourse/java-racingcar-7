package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AttemptCountValidatorTest {

    private final AttemptCountValidator validator = new AttemptCountValidator();

    @DisplayName("유효한 시도 횟수 테스트")
    @Test
    void validateValidInput() {
        String validInput = "3";
        validator.validate(validInput);
    }

    @DisplayName("양수가 아닌 시도 횟수 테스트")
    @Test
    void validateNegativeInput() {
        String invalidInput = "-1";
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("0인 시도 횟수 테스트")
    @Test
    void validateZeroInput() {
        String invalidInput = "0";
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("null인 시도 횟수 테스트")
    @Test
    void validateNullInput() {
        String invalidInput = null;
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("빈 문자열 시도 횟수 테스트")
    @Test
    void validateEmptyInput() {
        String invalidInput = "";
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("숫자가 아닌 시도 횟수 테스트")
    @Test
    void validateNotIntegerInput() {
        String invalidInput = "abc";
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }
}
