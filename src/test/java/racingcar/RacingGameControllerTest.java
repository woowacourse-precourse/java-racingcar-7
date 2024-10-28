package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameControllerTest {

    @Test
    void parseCarNames_ReturnsListOfCarNames() {
        // given
        RacingGameController controller = new RacingGameController();
        String input = "pobi,crong,honux";

        // when
        List<String> carNames = controller.parseCarNames();

        // then
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }
}
