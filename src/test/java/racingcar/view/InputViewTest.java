package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputView inputView = new InputView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    void requestCarNames() {
        String expectedInput = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));
        String actualInput = inputView.requestCarNames();

        assertEquals(expectedInput, actualInput);
        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", outputStreamCaptor.toString().trim());
    }

    @Test
    void requestNumAttempts() {
        String expectedInput = "5";
        System.setIn(new ByteArrayInputStream(expectedInput.getBytes()));
        String actualInput = inputView.requestNumAttempts();

        assertEquals(expectedInput, actualInput);
        assertEquals("시도할 횟수는 몇 회인가요?", outputStreamCaptor.toString().trim());
    }
}