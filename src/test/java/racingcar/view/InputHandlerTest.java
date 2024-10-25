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

    @ParameterizedTest
    @ValueSource(strings = {"0", "00", "000", "-5"})
    void 시도_횟수가_0_또는_이하면_예외_발생(String attemptCount) {
        // when & then
        assertThatThrownBy(() -> InputHandler.validateAttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    public void 시도_횟수가_0이_아니면_예외_없음(String attemptCount) {
        // when & then
        assertDoesNotThrow(() -> InputHandler.validateAttemptCount(attemptCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "123a", "0,0","#$%^*5"})
    void 숫자_외의_값은_예외_발생(String attemptCount) {
        // when & then
        assertThatThrownBy(() -> InputHandler.validateAttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
