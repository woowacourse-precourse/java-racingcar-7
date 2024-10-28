package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import validator.InputValidator;

public class ValidatorTest {


    @Test
    void 시도횟수_음수일때_예외테스트() {
        int input = -1;
        assertThatThrownBy(() -> InputValidator.validatePositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 양의 정수여야 합니다.");
    }

    @Test
    void 시도횟수_0일때_예외테스트() {
        int input = 0;
        assertThatThrownBy(() -> InputValidator.validateZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 0보다 커야 합니다.");

    }

    
}
