package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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

        Assertions.assertThat(carName).isEqualTo(userInput);
        Assertions.assertThat(carName).isNotEqualTo(noInput);

    }
}