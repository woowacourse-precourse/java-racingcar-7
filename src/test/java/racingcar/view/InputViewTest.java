package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void beforeEach() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("자동차 이름 입력을 받아 반환하는지 확인하는 테스트")
    void getCarNamesInput() {
        // given
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String carNamesInput = inputView.getCarNamesInput();

        // then
        assertThat(carNamesInput).isEqualTo(input);
    }
}