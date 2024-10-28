package racingcar.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void 단독_우승자_메시지_출력() {
        System.setOut(new PrintStream(outputStreamCaptor));
        String winner = "pobi";
        OutputView.printSoloWinnerMessage(winner);

        assertThat(outputStreamCaptor.toString()).isEqualTo("최종 우승자 : pobi\n");
    }

    @Test
    void 공동_우승자_메시지_출력() {
        System.setOut(new PrintStream(outputStreamCaptor));
        List<String> winnerNames = List.of("pobi", "jun");
        OutputView.printJointWinnerMessage(winnerNames);

        assertThat(outputStreamCaptor.toString()).isEqualTo("최종 우승자 : pobi, jun\n");
    }
}
