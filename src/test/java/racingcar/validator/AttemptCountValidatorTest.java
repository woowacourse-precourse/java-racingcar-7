package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;

public class AttemptCountValidatorTest {

    private AttemptCountValidator attemptCountValidator = new AttemptCountValidator();

    @Test
    void 음수_입력() {
        assertThatCode(() -> attemptCountValidator.validate("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a non-negative integer.");
    }

    @Test
    void 소수_입력() {
        assertThatCode(() -> attemptCountValidator.validate("0.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a non-negative integer.");
    }

    @Test
    void 식_입력() {
        assertThatCode(() -> attemptCountValidator.validate("1+3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a non-negative integer.");
    }

    @Test
    void 문자열_입력() {
        assertThatCode(() -> attemptCountValidator.validate("hello"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input a non-negative integer.");
    }
}
