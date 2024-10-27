package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 초과일 경우 예외를 발생시킨다")
    void validateNameLength() {
        String[] names = {"pobi", "javaji"};

        assertThatThrownBy(() -> InputValidator.validateNameLength(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함될 경우")
    void validateNameEmpty() {
        String[] names = {"pobi", "woni", " "};

        assertThatThrownBy(() -> InputValidator.validateNameEmpty(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 입력이 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 음수일 경우 예외를 발생시킨다")
    void validateTime() {
        int negativeTime = -1;

        assertThatThrownBy(() -> InputValidator.validateTime(negativeTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 0 이상의 정수여야 합니다.");
    }
}
