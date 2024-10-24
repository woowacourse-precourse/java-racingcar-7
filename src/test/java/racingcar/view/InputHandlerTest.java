package racingcar.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputHandlerTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",pobi,", "pobi,,woni", "pobi!", "123", "abcdef"})
    void 올바르지_않은_입력값_예외_발생(String carNames) {
        // when & then
        assertThatThrownBy(() -> validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
