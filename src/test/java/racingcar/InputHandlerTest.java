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

    @Test
    @DisplayName("공백 문자 또는 빈 문자열을 입력받으면 예외 처리한다")
    void parseCarNames_Test2() {
        List<String> result = inputHandler.parseCarNames("");  // when
        assertThat(result).containsExactly("pobi", "woni", "jun");  // then
    }
}
