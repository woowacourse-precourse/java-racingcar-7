package racingcar.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InputHandlerTest {
    private final InputHandler inputHandler = new InputHandler();

    @DisplayName("자동차 이름을 입력받을 수 있다.")
    @Test
    public void testGetCarNames() {
        // given
        // 입력 스트림을 설정하여 Console.readLine() 대체함
        String carNames = "poby,woni,jun\n";
        InputStream in = new ByteArrayInputStream(carNames.getBytes(UTF_8));
        System.setIn(in);

        // when
        String[] carNamesArray = inputHandler.getCarNames();

        // then
        assertArrayEquals(carNamesArray, new String[]{"poby", "woni", "jun"});
    }

}