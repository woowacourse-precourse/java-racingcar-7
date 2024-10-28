package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.input.ConsoleInputView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleInputViewTest {

    private ConsoleInputView inputView;
    private ByteArrayInputStream testIn;
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        inputView = new ConsoleInputView();
        System.setOut(new PrintStream(testOut));
    }

    @Test
    @DisplayName("자동차 이름을 입력받는다")
    void readCarNames() {
        // given
        String input = "pobi,woni,jun\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // when
        String names = inputView.readCarNames();

        // then
        assertEquals("pobi,woni,jun", names);
        assertTrue(testOut.toString().contains("경주할 자동차 이름을 입력하세요"));
    }

    @Test
    @DisplayName("시도 횟수를 입력받는다")
    void readRounds() {
        // given
        String input = "5\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        // when
        String rounds = inputView.readRounds();

        // then
        assertEquals("5", rounds);
        assertTrue(testOut.toString().contains("시도할 횟수는 몇 회인가요?"));
    }

    @AfterEach
    void restore() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
