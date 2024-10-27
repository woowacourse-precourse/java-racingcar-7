package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AttemptCountValidatorTest {

    private final AttemptCountValidator validator = new AttemptCountValidator();

    @DisplayName("유효한 시도 횟수 테스트")
    @Test
    void validateValidInput() {
        // 유효한 입력을 테스트
        String validInput = "3"; // 유효한 입력
        validator.validate(validInput); // 예외가 발생하지 않아야 함
    }

    @DisplayName("양수가 아닌 시도 횟수 테스트")
    @Test
    void validateNegativeInput() {
        String invalidInput = "-1"; // 잘못된 입력
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("0인 시도 횟수 테스트")
    @Test
    void validateZeroInput() {
        String invalidInput = "0"; // 잘못된 입력
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("null인 시도 횟수 테스트")
    @Test
    void validateNullInput() {
        String invalidInput = null; // 잘못된 입력
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("빈 문자열 시도 횟수 테스트")
    @Test
    void validateEmptyInput() {
        String invalidInput = ""; // 잘못된 입력
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }

    @DisplayName("숫자가 아닌 시도 횟수 테스트")
    @Test
    void validateNotIntegerInput() {
        String invalidInput = "abc"; // 잘못된 입력
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidInput));
    }
}
