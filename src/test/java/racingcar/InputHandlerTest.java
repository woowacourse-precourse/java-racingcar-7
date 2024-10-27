package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.InputHandler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;

public class InputHandlerTest {

    @Test
    @DisplayName("올바른 자동차 이름 입력 테스트")
    void validCarNames() {
        String input = "pobi,woni,jun";
        List<String> carNames = InputHandler.getCarNames(input);
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름 길이 초과 테스트")
    void invalidCarNamesLength() {
        String input = "pobi,woni,junttt";
        assertThatThrownBy(() -> InputHandler.getCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자이상 5자이하로 설정해야합니다!");
    }

    @Test
    @DisplayName("올바른 이동 횟수 입력 테스트")
    void validRaceAttempts() {
        String input = "5";
        int attempts = InputHandler.getRaceAttempts(input);
        assertThat(attempts).isEqualTo(5);
    }

    @Test
    @DisplayName("음수 이동 횟수 입력 테스트")
    void invalidRaceAttempts() {
        String input = "-1";
        assertThatThrownBy(() -> InputHandler.getRaceAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 1회 이상이어야 합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 이동 횟수 입력 테스트")
    void nonNumericRaceAttempts() {
        String input = "five";
        assertThatThrownBy(() -> InputHandler.getRaceAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 숫자여야 합니다.");
    }
}