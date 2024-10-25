package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("시도 횟수로 문자를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {".", "d", "fdsafa", "test"})
    void 시도횟수_문자_입력(String input) {
        Assertions.assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수만 입력하세요.");
    }

    @DisplayName("시도 횟수로 실수를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"3.4", "5.2", "1.0", "2.0"})
    void 시도횟수_실수_입력(String input) {
        Assertions.assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수만 입력하세요.");
    }

    @DisplayName("시도 횟수로 null을 입력한 경우")
    @Test
    void 시도횟수_null_입력() {
        Assertions.assertThatThrownBy(() -> new Number(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수를 입력하세요.");
    }

    @DisplayName("시도 횟수로 공백을 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 시도횟수_공백_입력(String input) {
        Assertions.assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수를 입력하세요.");
    }

    @DisplayName("시도 횟수로 0을 입력한 경우")
    @Test
    void 시도횟수_0_입력() {
        Assertions.assertThatThrownBy(() -> new Number("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력하세요.");
    }

    @DisplayName("시도 횟수로 음수를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10", "-340"})
    void 시도횟수_음수_입력(String input) {
        Assertions.assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력하세요.");
    }

}