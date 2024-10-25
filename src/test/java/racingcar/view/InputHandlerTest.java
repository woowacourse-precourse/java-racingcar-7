package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",pobi,", "pobi,,woni", "pobi!", "abcdef"})
    void 올바르지_않은_입력값_예외_발생(String carNames) {
        // when & then
        assertThatThrownBy(() -> InputHandler.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "car1,car2"})
    void 올바른_입력값_예외_없음(String carNames) {
        //when & then
        assertDoesNotThrow(() -> InputHandler.validateCarNames(carNames));
    }

    @Test
    void 시도_횟수가_0이면_예외_발생() {
        // given
        int attemptCount = 0;

        // when & then
        assertThatThrownBy(() -> InputHandler.validateAttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void 시도_횟수가_0이_아니면_예외_없음(int attemptCount) {
        // when & then
        assertDoesNotThrow(() -> InputHandler.validateAttemptCount(attemptCount));
    }
}
