package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @ParameterizedTest
    @DisplayName("자동차 이름에 허용되지 않는 문자가 있으면 예외가 발생한다")
    @ValueSource(strings = {"car!", "car@", "car#", "car$"})
    void validateInvalidCharacters(String name) {
        assertThatThrownBy(() -> InputValidator.validateName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한글, 영문, 숫자만 가능합니다");
    }

    @Test
    @DisplayName("시도 횟수가 최대값을 초과하면 예외가 발생한다")
    void validateMaxAttempts() {
        String input = "101";  // MAX_ATTEMPTS = 100

        assertThatThrownBy(() -> InputValidator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대");
    }
}