package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberOfAttemptsValidatorTest {
    NumberOfAttemptsValidator validator = new NumberOfAttemptsValidator();

    @DisplayName("시도할 횟수의 입력값이 숫자인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"", "one", "***", "-1"})
    void 시도할_횟수가_숫자인지_검증(String input) {
        assertThatThrownBy(() -> validator.validateNumberOfAttempts(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수의 입력값이 자연수인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1.5", "-10"})
    void 시도할_횟수가_자연수인지_검증(String input) {
        assertThatThrownBy(() -> validator.validateNumberOfAttempts(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}