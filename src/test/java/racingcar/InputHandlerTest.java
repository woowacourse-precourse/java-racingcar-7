package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private final InputHandler inputHandler = new InputHandler();

    @Test
    void parseCarNames_WhenValidInputProvided_ReturnsListOfCarNames() {
        String carNames = "pobi,woni,jun";  // given
        List<String> result = inputHandler.parseCarNames(carNames);  // when
        assertThat(result).containsExactly("pobi", "woni", "jun");  // then
    }
}
