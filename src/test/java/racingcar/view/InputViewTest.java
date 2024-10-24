package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @DisplayName("자동차 이름 입력 테스트")
    @Test
    void carName() {
        InputView inputView = new InputView();
        String userInput = "pobi";
        String noInput = "jun";

        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        String carName = inputView.carName();

        assertThat(carName).isEqualTo(userInput);
        assertThat(carName).isNotEqualTo(noInput);

    }

    @DisplayName("이동횟수는 숫자만 입력 가능하다.")
    @Test
    void 이동횟수_입력_테스트() {
        InputView inputView = new InputView();
        String validInput = "10";
        String invalidInput = "ㄱ";

        ByteArrayInputStream in = new ByteArrayInputStream(validInput.getBytes());
        System.setIn(in);

        int tryCount = inputView.tryCount();

        assertThat(tryCount).isEqualTo(10);

        in = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::tryCount)
                .isInstanceOf(IllegalArgumentException.class);

    }
}