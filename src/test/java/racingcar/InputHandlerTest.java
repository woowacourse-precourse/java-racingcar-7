package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {
    class TestConsoleReader implements ConsoleReader {
        private final String[] inputs;
        private int index = 0;

        public TestConsoleReader(String... inputs) {
            this.inputs = inputs;
        }

        @Override
        public String readLine() {
            return inputs[index++];
        }
    }

    @Test
    void testInputCarNames() {
        String[] inputs = {"car1,car2,car3"};
        InputHandler inputHandler = new InputHandler(new TestConsoleReader(inputs));

        String[] carNames = inputHandler.inputCarNames();

        assertArrayEquals(new String[]{"car1", "car2", "car3"}, carNames);
    }

    @Test
    void testInputMoveCount() {
        String[] inputs = {"5"};
        InputHandler inputHandler = new InputHandler(new TestConsoleReader(inputs));

        int moveCount = inputHandler.inputMoveCount();

        assertEquals(5, moveCount);
    }
}
