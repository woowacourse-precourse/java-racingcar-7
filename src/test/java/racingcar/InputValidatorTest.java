package racingcar;

import static racingcar.ErrorCode.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스 테스트")
public class InputValidatorTest {

    @Test
    void 쉼표가_연속적으로_입력된_경우_예외를_발생한다() {
        // given
        String carNames = "a,,b";

        // when & then
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CONSECUTIVE_COMMA.getMessage());
    }
}
