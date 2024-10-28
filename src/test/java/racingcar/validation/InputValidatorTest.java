package racingcar.validation;
import racingcar.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class InputValidatorTest {
    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"banana", "pobi123", "wonicar"})
    void validateCarNameLength(String name) {
        assertThatThrownBy(() -> InputValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.ERROR_NAME_LENGTH);
    }

    @DisplayName("자동차 이름이 비어있거나 공백이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateEmptyCarName(String name) {
        assertThatThrownBy(() -> InputValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.ERROR_EMPTY_NAME);
    }

    @DisplayName("자동차 이름이 5글자 이하면 정상 처리된다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void validateValidCarName(String name) {
        assertThatCode(() -> InputValidator.validateCarName(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수가 0 이하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10"})
    void validateNegativeMovement(String movement) {
        assertThatThrownBy(() -> InputValidator.validateMovement(movement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.ERROR_MOVEMENT_ZERO);
    }

    @DisplayName("입력값이 콤마로 끝나면 예외가 발생한다")
    @Test
    void validateInputEndingWithComma() {
        assertThatThrownBy(() -> InputValidator.validateInputFormat("pobi,woni,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.ERROR_INVALID_FORMAT);
    }

    @DisplayName("자동차 이름이 중복되면 예외가 발생한다")
    @Test
    void validateDuplicateCarNames() {
        assertThatThrownBy(() -> InputValidator.validateDuplicateCarNames(Arrays.asList("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.ERROR_DUPLICATE_NAME);
    }

    @DisplayName("자동차 이름에 공백이 포함되면 예외가 발생한다")
    @Test
    void validateCarNameWithSpace() {
        assertThatThrownBy(() -> InputValidator.validateCarNamesSeparator("pobi woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.ERROR_INVALID_SEPARATOR);
    }

    @DisplayName("시도 횟수에 숫자가 아닌 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "!"})
    void validateNonNumericMovement(String input) {
        assertThatThrownBy(() -> InputValidator.validateMovementString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constants.ERROR_NON_NUMERIC);
    }
}
