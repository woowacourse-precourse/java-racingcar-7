package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleInputViewTest {

    ConsoleInputView consoleInputView;

    @BeforeEach
    void setUp() {
        consoleInputView = new ConsoleInputView();
    }

    @Test
    void 자동차_이름_입력_테스트() {
        //given
        System.setIn(createUserInput("pobi,woni,jun"));

        //when
        String input = consoleInputView.inputCarNameList();

        //then
        Assertions.assertThat(input)
                .isEqualTo("pobi,woni,jun");
    }

    @Test
    void 시도할_횟수_입력_테스트() {
        //given
        System.setIn(createUserInput("5"));

        //when
        String input = consoleInputView.inputAttemptCount();

        //then
        Assertions.assertThat(input)
                .isEqualTo("5");
    }

    @Test
    void readLine() {
        //given
        System.setIn(createUserInput("aaaaaaa"));

        //when
        String input = consoleInputView.inputAttemptCount();

        //then
        Assertions.assertThat(input)
                .isEqualTo("aaaaaaa");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
