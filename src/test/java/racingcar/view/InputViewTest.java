package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView = new InputView();

    @Test
    void 입력_기능_테스트() {
        // given
        String inputValue = "test";
        System.setIn(new ByteArrayInputStream(inputValue.getBytes()));

        // when
        String input = inputView.input();

        // then
        assertThat(input).isEqualTo(inputValue);
    }

    @Test
    void 숫자_입력_기능_테스트() {
        // given
        String inputValue = "1";
        Long inputValueLong = Long.parseLong(inputValue);
        System.setIn(new ByteArrayInputStream(inputValue.getBytes()));

        // when
        Long input = inputView.longInput();

        // then
        assertThat(input).isEqualTo(inputValueLong);
    }

    @AfterEach
    void recovery() {
        inputView.closeReadLine();
    }
}