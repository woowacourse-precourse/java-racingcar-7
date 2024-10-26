package racingcar.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputConsoleTest {

    @Test
    void withoutLineBreakingTest() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final String message = "testMessage";
        final OutputConsole outputConsole = new OutputConsole();
        outputConsole.printWithLineBreak(message);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo(message + "\n");
    }

    @Test
    void withLineBreakingTest() {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final PrintStream outputStream = new PrintStream(byteArrayOutputStream);
        System.setOut(outputStream);

        final String message = "testMessage";
        final OutputConsole outputConsole = new OutputConsole();
        outputConsole.print(message);

        Assertions.assertThat(byteArrayOutputStream.toString())
                .isEqualTo(message);
    }
}