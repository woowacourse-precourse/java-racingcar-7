package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void inputCarNames() {
        // given
        String simulatedInput = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // when
        String[] result = InputView.inputCarNames().split(",");

        // then
        assertArrayEquals(new String[]{"car1", "car2", "car3"}, result);
    }

    @Test
    void inputTryCount() {
        // given
        String simulatedInput = "5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // when
        String result = InputView.inputTryCount();

        // then
        assertEquals("5", result);
    }
}