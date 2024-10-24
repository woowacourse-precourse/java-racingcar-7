package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputPrinterTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 자동차_이름_입력_요청_메시지_출력() {
        var runner = new OutputPrinter();
        runner.promptCarNames();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void 시도_횟수_입력_요청_메시지_출력() {
        var runner = new OutputPrinter();
        runner.promptAttemptCount();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("시도할 횟수는 몇 회인가요?");
    }
}
