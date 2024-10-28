package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("시도 횟수를 정상적으로 입력받는지 확인")
    @Test
    void askTryCount() {
        // given
        InputView inputView = new InputView();
        String data = "5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        // when
        String maybeTryCount = inputView.askTryCount();

        // then
        assertThat(maybeTryCount).isEqualTo("5");
    }
}