package racingcar.io.input.impl;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

class InputConsoleTest {
    private final InputConsole inputConsole = new InputConsole();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 자동차_이름을_입력받아_반환한다() {
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String result = inputConsole.getCarNames();

        assertThat(result).isEqualTo(input);
    }

    @Test
    void 시도할_횟수를_입력받아_Round_객체로_반환한다() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Round round = inputConsole.getRaceRounds();

        assertThat(round.value()).isEqualTo(5);
    }
}
