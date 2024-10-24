package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    @DisplayName("입력이 정상적으로 들어오는지")
    void getInput() {
        String given = "pobi,woni,jun";
        String expected = "pobi,woni,jun";
        InputHandler inputHandler = new InputHandler();
        System.setIn(new ByteArrayInputStream(given.getBytes()));

        String result = inputHandler.getInput();

        assertEquals(expected, result);
    }
}
