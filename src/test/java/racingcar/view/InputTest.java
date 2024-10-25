package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static racingcar.view.InputView.parseTryCount;
import static racingcar.view.InputView.validateWhitespace;
import static racingcar.view.InputView.validateCarNames;
import static racingcar.view.InputView.validateNumberFormat;
import static racingcar.view.InputView.validateTryCount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputTest {
    @Test
    @DisplayName("횟수가 숫자가 아닌 경우")
    void exceptionIfCountNotInteger() {
        String countString = "a";
        assertThatThrownBy(() -> validateNumberFormat(countString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수가 실수인 경우")
    void exceptionIfCountFloat() {
        String countString = "3.5";
        assertThatThrownBy(() -> parseTryCount(countString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수에 공백이 포함된 경우")
    void exceptionIfCountWhiteSpace() {
        String countString = " 1";
        assertThatThrownBy(() -> validateWhitespace(countString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("횟수가 음수 혹은 0인 경우")
    @ValueSource(ints = {0, -1})
    public void exceptionIfCountNotPositive(int count) {
        assertThatThrownBy(() -> validateTryCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("횟수가 비정상적으로 많은 경우")
    @ValueSource(ints = {2000000000, 99999999})
    public void exceptionIfCountMaxCount(int count) {
        assertThatThrownBy(() -> validateTryCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
