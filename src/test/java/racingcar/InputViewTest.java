package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("사용자 입력을 정상적으로 받는지 확인")
    @Test
    void ask() {
        // given
        InputView inputView = new InputView();
        String data = "pobi,crong,honux\n5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        // when
        ConsoleInput consoleInput = inputView.ask();

        // then
        assertThat(consoleInput).isEqualTo(new ConsoleInput("pobi,crong,honux", "5"));
    }

}