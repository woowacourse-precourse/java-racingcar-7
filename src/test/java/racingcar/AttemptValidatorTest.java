package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AttemptValidatorTest {

    @Test
    void validateInt() {
        // Given
        String input = "c";

        // When

        // Then
        Assertions.assertThatThrownBy(() -> AttemptValidator.validatePositiveInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수를 입력해주세요.");
    }

    @Test
    void validatePositiveInt() {
        // Given
        String input = "-3";

        // When

        // Then
        Assertions.assertThatThrownBy(() -> AttemptValidator.validatePositiveInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 양수만 가능합니다.");
    }
}