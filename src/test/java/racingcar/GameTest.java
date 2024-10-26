package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class GameTest {

    private void setConsoleInput(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
    }

    @Test
    void 자동차목록을_입력받아_전달한다() {
        String input = "pobi,woni,jun";
        setConsoleInput(input);

        InputView inputView = new InputView();
        String carNames = inputView.requestCarNames();

        assertThat(carNames)
                .isEqualTo("pobi,woni,jun");
    }

}