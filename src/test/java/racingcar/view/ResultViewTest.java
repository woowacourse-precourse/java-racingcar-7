package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @BeforeEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void 실행_결과_문구_출력() {
        ResultView.promptExecutionResult();

        assertThat(outputStream.toString().trim()).isEqualTo("실행 결과");
    }

    @Test
    void 최종_우승자_출력() {
        List<String> winners = List.of("pobi", "nana");
        ResultView.showWinners(winners);

        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, nana");
    }
}
