package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("입력된 자동차 이름이 공백이거나 빈 문자열일 경우 예외를 발생시킨다.")
    @Test
    void validateCarNames_blankOrEmpty_throwsException() {

        assertThatThrownBy(() -> InputValidator.validateCarNames("   ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 비어있습니다.");

        assertThatThrownBy(() -> InputValidator.validateCarNames("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 비어있습니다.");
    }

    @DisplayName("이동 횟수 입력이 공백이거나 빈 문자열일 경우 예외를 발생시킨다.")
    @Test
    void validateTotalRounds_blankOrEmpty_throwsException() {

        assertThatThrownBy(() -> InputValidator.validateTotalRounds("   ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 비어있습니다.");

        assertThatThrownBy(() -> InputValidator.validateTotalRounds("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 비어있습니다.");
    }

    @DisplayName("이동 횟수 입력이 숫자가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateTotalRounds_nonNumeric_throwsException() {
        assertThatThrownBy(() -> InputValidator.validateTotalRounds("abc")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 숫자여야 합니다.");
    }

    @DisplayName("이동 횟수가 0 또는 음수일 경우 예외를 발생시킨다.")
    @Test
    void validateTotalRounds_nonPositive_throwsException() {

        assertThatThrownBy(() -> InputValidator.validateTotalRounds("0")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 1 이상의 자연수여야 합니다.");

        assertThatThrownBy(() -> InputValidator.validateTotalRounds("-1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 1 이상의 자연수여야 합니다.");
    }
}