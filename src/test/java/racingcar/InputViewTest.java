package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.controller.ViewController;

class InputViewTest {

    @Test
    void inputTryCount() {
        // given
        String simulatedInput = "5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // when
        String result = ViewController.inputTryCount();

        // then
        assertEquals("5", result);
    }
}