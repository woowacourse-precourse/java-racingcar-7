package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @DisplayName("이동횟수는 숫자만 입력 가능하다.")
    @Test
    void 이동횟수_입력_테스트() {
        InputView inputView = new InputView();
        String invalidInput = "ㄱ";

        ByteArrayInputStream in = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::tryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}