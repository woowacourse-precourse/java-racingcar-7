package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingViewTest {
    @Test
    void 우승자_출력_포맷_테스트() {
        RacingView view = new RacingView();
        List<String> winners = Arrays.asList("car1", "car2");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        view.printWinners(winners);

        String expectedOutput = "최종 우승자 : car1, car2\r\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
        System.setOut(System.out);
    }
}
