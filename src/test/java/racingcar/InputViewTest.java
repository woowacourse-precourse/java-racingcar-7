package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("자동차 이름을 정상적으로 입력받는지 확인")
    @Test
    void askCarNames() {
        // given
        InputView inputView = new InputView();
        String data = "pobi,crong,honux";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        // when
        String maybeNames = inputView.askCarNames();

        // then
        assertThat(maybeNames).isEqualTo("pobi,crong,honux");
    }
}