package racingcar.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

class InputHandlerTest {
    private final InputHandler inputHandler = new InputHandler();

    @DisplayName("자동차 이름을 입력받을 수 있다.")
    @Test
    public void testCarNamesInput() {
        // given
        // 입력 스트림을 설정하여 Console.readLine() 대체함
        String carNamesInput = "poby,woni,jun\n";
        InputStream in = new ByteArrayInputStream(carNamesInput.getBytes(UTF_8));
        System.setIn(in);

        // when
        String[] carNamesArray = inputHandler.getCarNames();

        // then
        Assertions.assertThat(carNamesArray).isEqualTo(new String[]{"poby", "woni", "jun"});
    }

    @DisplayName("시도 횟수를 입력받을 수 있다.")
    @Test
    public void testTryNumInput() {
        // given
        // 입력 스트림을 설정하여 Console.readLine() 대체함
        String tryNumInput = "5\n";
        InputStream in = new ByteArrayInputStream(tryNumInput.getBytes(UTF_8));
        System.setIn(in);

        // when
        int tryNum = inputHandler.getTryNum();

        // then
        Assertions.assertThat(tryNum).isEqualTo(5);
    }

}