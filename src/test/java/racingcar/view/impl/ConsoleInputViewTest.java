package racingcar.view.impl;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.constant.OutputMessage;

class ConsoleInputViewTest {
    private ConsoleInputView consoleInputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        consoleInputView = ConsoleInputView.getInstance();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("자동차_이름_표시_요청_테스트")
    void testDisplayCarNameRequest() {
        assertSimpleTest(() -> {
            String input = "Car1,Car2";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String result = consoleInputView.displayCarNameRequest();

            String expectedOutput = OutputMessage.INPUT_CAR_NAMES.getMessage() + System.lineSeparator();
            assertEquals(expectedOutput.trim(), outputStream.toString().trim());
            assertEquals("Car1,Car2", result);
        });
    }

    @Test
    @DisplayName("라운드_표시_요청_테스트")
    void testDisplayRoundRequest() {
        assertSimpleTest(() -> {
            String input = "5";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String result = consoleInputView.displayRoundRequest();

            String expectedOutput = OutputMessage.INPUT_ROUND.getMessage() + System.lineSeparator();
            assertEquals(expectedOutput.trim(), outputStream.toString().trim());
            assertEquals("5", result);
        });
    }
}