package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConsoleHandlerTest {


    @Test
    @DisplayName("콘솔에 자동차 이름을 입력하라는 안내 메시지를 출력한다")
    void showCarNameInputGuideMessageTest() {
        // given
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        // when
        inputConsoleHandler.showCarNameGuideMessage();

        // then
        assertThat(byteArrayOutputStream.toString()).isEqualTo(
                "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator());

        System.setOut(System.out);

    }

}