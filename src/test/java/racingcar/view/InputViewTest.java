package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputView inputView = new InputView();
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        Console.close();
    }

    @Test
    void inputCarNames() {
        String testInput = "car1,car2\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        String carNames = inputView.inputCarNames();

        assertThat("car1,car2").isEqualTo(carNames);
        assertThat(outContent.toString()).contains("경주할 자동차 이름을 입력하세요.");
    }

    @Test
    void inputRaceRounds() {
        String testInput = "5\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        String rounds = inputView.inputRaceRounds();

        assertThat("5").isEqualTo(rounds);
        assertThat(outContent.toString()).contains("시도할 횟수는 몇 회인가요?");
    }
}