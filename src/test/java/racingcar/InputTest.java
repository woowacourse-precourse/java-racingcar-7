package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputTest {

    private Input input = new Input();

    @Test
    void 자동차_이름_트림_분리_확인() {
        List<String> carNames = input.trimCarNames(List.of(" pobi ", "  woni", "jun"));
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 게임_횟수_문자열에서_정수로_변환_확인() {
        int gameCount = input.convertStrToInt("5");
        assertThat(gameCount).isEqualTo(5);
    }

    @Test
    void 숫자_형식의_시도_횟수_검사() {
        assertThatCode(() -> Validate.validateGameCountIsNumber("56"))
                .doesNotThrowAnyException();
    }

    @Test
    void 문자_형식의_시도_횟수_검사() {
        assertThatThrownBy(() -> Validate.validateGameCountIsNumber("5a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자여야 합니다.");

        assertThatThrownBy(() -> Validate.validateGameCountIsNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 숫자여야 합니다.");
    }

}