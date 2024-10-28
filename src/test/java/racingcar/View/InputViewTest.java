package racingcar.View;

import org.junit.jupiter.api.Test;
import racingcar.Exception.InputException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputViewTest {

    @Test
    void 음수_시도횟수_입력시_예외발생() {
        assertThatThrownBy(() -> {
            InputException.checkRound(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 횟수는 양수만 가능합니다.");
    }
}