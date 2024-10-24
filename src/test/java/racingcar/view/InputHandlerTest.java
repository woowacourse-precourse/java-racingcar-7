package racingcar.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",pobi,", "pobi,,woni", "pobi!", "abcdef"})
    void 올바르지_않은_입력값_예외_발생(String carNames) {
        // when & then
        assertThatThrownBy(() -> validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun", "car1, car2"})
    void 올바른_입력값_예외_없음(String carNames) {
        //when & then
        assertDoesNotThrow(() -> validateCarNames(carNames));
    }
}
