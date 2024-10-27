package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @DisplayName("시도할 횟수가 숫자가 아닌 경우")
    @Test
    void inputMoveCountNotNumber() {
        System.setIn(new java.io.ByteArrayInputStream("a".getBytes()));

        assertThatThrownBy(InputView::inputMoveCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 자연수만 가능합니다.");
    }
}
