package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class InputViewTest {

    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputView inputView = new InputView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void requestCarNames() {
        inputView.requestCarNames();
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", outputStreamCaptor.toString().trim());
    }

    @Test
    void requestNumAttempt() {
        inputView.requestNumAttempt();
        assertEquals("시도할 횟수는 몇 회인가요?", outputStreamCaptor.toString().trim());
    }

    @Test
    void readInput() {
        String expected = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(expected.getBytes()));

        String actual = inputView.readInput();
        assertEquals(expected, actual);
    }
}