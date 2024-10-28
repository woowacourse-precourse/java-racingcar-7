package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @Test
    @DisplayName("올바른 자동차 이름 검증")
    void validCarName() {
        InputValidator.validateCarName("pobi");
    }

    @Test
    @DisplayName("빈 자동차 이름 검증")
    void emptyCarName() {
        assertThatThrownBy(() -> InputValidator.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("5자보다 긴 자동차 이름 검증")
    void longCarName() {
        assertThatThrownBy(() -> InputValidator.validateCarName("pobiiii"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "9", "27"})
    @DisplayName("올바른 시도 횟수 검증")
    void validAttempts(String input) {
        int attempts = InputValidator.validateAttempts(input);
        assertThat(attempts).isGreaterThan(0);
    }

    @Test
    @DisplayName("음수 시도 횟수 검증")
    void negativeAttempts() {
        assertThatThrownBy(() -> InputValidator.validateAttempts("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }

    @Test
    @DisplayName("문자열 시도 횟수 검증")
    void nonNumericAttempts() {
        assertThatThrownBy(() -> InputValidator.validateAttempts("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }

}