package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private final InputHandler inputHandler = new InputHandler();

    @Test
    @DisplayName("올바른 입력을 받았을 때 자동차 이름 리스트를 반환한다")
    void parseCarNames_Test() {
        String carNames = "pobi,woni,jun";  // given
        List<String> result = inputHandler.parseCarNames(carNames);  // when
        assertThat(result).containsExactly("pobi", "woni", "jun");  // then
    }
}
