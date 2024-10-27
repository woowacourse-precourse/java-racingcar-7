package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @DisplayName("숫자로만 구성된 문자열이면 통과")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "0123456789"})
    void passWhenInputHasNumbersOnly(String input) {
        assertThatCode(() -> new InputValidator().validateThatContainsOnlyDigits(input)).doesNotThrowAnyException();
    }

    @DisplayName("문자열에 숫자가 아닌 문자가 있으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "0회", "1,", ";2", "34번", "56회 시도"})
    void throwIllegalArgumentExceptionWhenInputHasNotNumbersOnly(String input) {
        assertThatThrownBy(() -> new InputValidator().validateThatContainsOnlyDigits(input))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}