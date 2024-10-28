package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void printCarNameInputPrompt_테스트() {
        OutputView outputView = new OutputView();
        outputView.printCarNameInputPrompt();

        String expected = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        assertThat(outputStream.toString().trim()).isEqualTo(expected);
    }

    @Test
    void printInputAttempsPrompt_테스트() {
        OutputView outputView = new OutputView();
        outputView.printInputAttempsPrompt();

        String expected = "시도할 횟수는 몇 회인가요?";
        assertThat(outputStream.toString().trim()).isEqualTo(expected);
    }

    @Test
    void printResultPrompt_테스트() {
        OutputView outputView = new OutputView();
        outputView.printResultPrompt();

        String expected = "실행 결과";
        assertThat(outputStream.toString().trim()).isEqualTo(expected);
    }
}
