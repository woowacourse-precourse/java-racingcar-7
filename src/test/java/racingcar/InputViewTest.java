package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    void 사용자에게_파라미터로_들어온_메시지를_출력합니다() {
        // given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        InputView inputView = new InputView();
        inputView.printMessage("hello");

        // then
        assertEquals("hello", out.toString().trim());

        System.setOut(System.out);
    }

    @Test
    void 사용자에게_문자열을_입력을받습니다() {
        // given
        String inputValue = "winter,woodz,karina\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);

        // when
        InputView inputView = new InputView();
        String inputResult = inputView.input();

        // then
        Assertions.assertEquals("winter,woodz,karina", inputResult.trim());
    }
}