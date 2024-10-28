package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    @DisplayName("자동차 이름이 비어있으면 IllegalArgumentException을 던져야 한다.")
    void validateCarNameEmpty() {
        String emptyCarName = "";

        assertThatThrownBy(() -> validator.validateCarName(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우 IllegalArgumentException을 던져야 한다.")
    void validateCarNameLength() {
        String longCarName = "harry-potter";

        assertThatThrownBy(() -> validator.validateCarName(longCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("유효한 이동 횟수를 입력할 경우 정수로 반환한다.")
    void validateAttemptCount_withValidInput() {
        String moveCountInput = "5";
        int result = validator.validateAttemptCount(moveCountInput);
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("빈 문자열을 입력할 경우 예외를 던진다.")
    @ValueSource(strings = {""," "})
    void validateAttemptCount_withEmptyInput(String input) {
        assertThatThrownBy(() -> validator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("null 값을 입력할 경우 예외를 던진다.")
    void validateAttemptCount_withNullInput() {
        String moveCountInput = null;
        assertThatThrownBy(() -> validator.validateAttemptCount(moveCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("음수 값을 입력할 경우 예외를 던진다.")
    void validateAttemptCount_withNegativeInput() {
        String moveCountInput = "-1";
        assertThatThrownBy(() -> validator.validateAttemptCount(moveCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 0 이상의 정수여야 합니다.");
    }

}