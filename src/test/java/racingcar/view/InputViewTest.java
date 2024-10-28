package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class InputViewTest {
    @AfterEach
    void restoreSystemIn() {
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void inputCarNameTest() {
        // given
        String input = "jeong,hun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String result = InputView.inputCarName();

        // then
        assertThat(result).isEqualTo("jeong,hun");
    }

    @Test
    void inputTryNumberTest() {
        //given
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String result = InputView.inputTryNumber();

        // then
        assertThat(result).isEqualTo("5");
    }
}
