package racingcar.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

class InputHandlerTest {
    private final InputHandler inputHandler = new InputHandler();

    @DisplayName("자동차 이름을 입력받을 수 있다.")
    @Test
    public void testCarNamesInput() throws IOException {
        // given
        String carNamesInput = "poby,woni,jun";
        InputStream in = new ByteArrayInputStream(carNamesInput.getBytes(UTF_8));
        System.setIn(in);

        // when
        String[] carNamesArray = inputHandler.getCarNames();

        // then
        Assertions.assertThat(carNamesArray).isEqualTo(new String[]{"poby", "woni", "jun"});

        in.close();
    }

    @DisplayName("시도 횟수를 입력받을 수 있다.")
    @Test
    public void testTryNumInput() throws IOException {
        // given
        String tryNumInput = "5";
        InputStream in = new ByteArrayInputStream(tryNumInput.getBytes(UTF_8));
        System.setIn(in);

        // when
        int tryNum = inputHandler.getTryNum();

        // then
        Assertions.assertThat(tryNum).isEqualTo(5);

        in.close();
    }

}