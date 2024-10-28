package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
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
}