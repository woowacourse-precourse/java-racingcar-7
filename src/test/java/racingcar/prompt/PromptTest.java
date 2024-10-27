package racingcar.prompt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;

abstract class PromptTest {

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    protected void setInput(String input) {
        if (input == null) {
            System.setIn(null);
        } else {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
        }
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}