package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("실행 결과 메시지 출력 확인")
    void printExecutionResult() {
        outputView.printExecutionResult();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("실행 결과");
    }

    @Test
    @DisplayName("최종 우승자 출력 메시지 확인")
    void printFinalRacingResult() {
        outputView.printFinalRacingResult(List.of("pobi", "woni"));
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : pobi, woni");
    }
}