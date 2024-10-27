package racingcar.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountValidatorTest {
    private static final String INVALID_TRY_COUNT_INPUT_MESSAGE = "시도 횟수를 잘못 입력하셨습니다.";
    private static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 최소 1번, 최대 100번까지 가능합니다.";

    @ParameterizedTest
    @ValueSource(strings = {"1", "100", "01", "0100", "050"})
    @DisplayName("시도횟수 입력이 정상적일 때 아무러 예외가 발생하지 않는다")
    void validaInputTest(String input) {
        assertDoesNotThrow(() -> TryCountValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"안녕", "👍", "abc"})
    @DisplayName("숫자형태가 아닐때 예외가 발생한다")
    void nonNumericInputTest(String input) {
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_TRY_COUNT_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3.5", "12.5", "99.9"})
    @DisplayName("소수점 형태일 때 예외가 발생한다")
    void decimalInputTest(String input) {
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_TRY_COUNT_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2147483648", "-2147483649"})
    @DisplayName("Integer 범위가 넘어가면 예외가 발생한다.")
    void outOfIntegerRangeInput(String input) {
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_TRY_COUNT_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", "0", "101", "1000"})
    @DisplayName("시도횟수 입력 범위가 1 이상 100 이하가 아닐 시 범위 예외가 발생한다")
    void outOfValidaRangeInputTest(String input) {
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_TRY_COUNT_MESSAGE);
    }
}
