package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import racingcar.controller.ViewController;

class ViewControllerTest {

    @Test
    void inputTryCount() {
        // given
        String simulatedInput = "5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // when
        String result = ViewController.readTryCount();

        // then
        assertEquals("5", result);
    }
}