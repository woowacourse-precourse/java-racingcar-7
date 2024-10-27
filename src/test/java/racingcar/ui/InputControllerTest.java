package racingcar.ui;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputControllerTest {

    @Test
    void 자동차_이름_입력() {
        final String input = "inputMessage";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        final InputController inputController = new InputController(new InputConsole());
        final InputCarNames inputCarNames = inputController.getInputCarNames();

        Assertions.assertThat(inputCarNames)
                .isEqualTo(new InputCarNames(input));
    }

    @Test
    void 게임_라운드_입력() {
        final String input = "count";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        final InputController inputController = new InputController(new InputConsole());
        final InputGameRoundCount inputRoundCount = inputController.getInputRoundCount();

        Assertions.assertThat(inputRoundCount)
                .isEqualTo(new InputGameRoundCount(input));
    }
}