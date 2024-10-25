package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingIOTest {
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(standardOut);
        System.out.println(getOutput());
    }

    @Test
    @DisplayName("시작 부분이 출력 형식을 준수하는지 확인")
    void 시작_부분_출력_테스트() {
        RacingIO.promptCarNamesInput();
        assertThat(getOutput()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        RacingIO.promptMoveCountInput();
        assertThat(getOutput()).contains("시도할 횟수는 몇 회인가요?");
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}
