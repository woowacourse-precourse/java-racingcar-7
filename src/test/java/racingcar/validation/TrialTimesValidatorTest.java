package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class TrialTimesValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "42", "100", "999", "0"})
    @DisplayName("올바른 숫자 형식이 입력되면 정상적으로 처리된다")
    void validateValidNumbers(String input) {
        assertThatCode(() -> TrialTimesValidator.validate(input))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "abc",          // 문자
        "12a",         // 숫자와 문자 혼합
        "1.5",         // 소수점
        " ",           // 공백
        "",            // 빈 문자열
        "일",          // 한글
        "1,000",       // 쉼표가 포함된 숫자
        "1_000",       // 언더스코어가 포함된 숫자
        "-1"           // 음수
    })
    @DisplayName("숫자가 아닌 입력이 들어오면 예외가 발생한다")
    void validateInvalidInput(String input) {
        assertThatThrownBy(() -> TrialTimesValidator.validate(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null이 입력되면 예외가 발생한다")
    void validateNullInput() {
        assertThatThrownBy(() -> TrialTimesValidator.validate(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "2147483648",   // Integer.MAX_VALUE + 1
        "-2147483649",  // Integer.MIN_VALUE - 1
        "9999999999"    // 매우 큰 수
    })
    @DisplayName("Integer 범위를 벗어나는 숫자는 예외가 발생한다")
    void validateOutOfRangeNumbers(String input) {
        assertThatThrownBy(() -> TrialTimesValidator.validate(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}