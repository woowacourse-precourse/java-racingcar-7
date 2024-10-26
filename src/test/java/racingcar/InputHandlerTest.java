package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private final InputHandler inputHandler = new InputHandler();

    @Test
    void 올바른_입력을_받았을_때_테스트() {
        String carNames = "pobi,woni,jun";  // given
        List<String> result = inputHandler.parseCarNames(carNames);  // when
        assertThat(result).containsExactly("pobi", "woni", "jun");  // then
    }
}
