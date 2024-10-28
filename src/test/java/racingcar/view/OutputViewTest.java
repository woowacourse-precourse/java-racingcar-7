package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;
import racingcar.view.output.TestWriter;

class OutputViewTest {

    private final TestWriter writer = new TestWriter();
    private final OutputView outputView = new OutputView(writer);

    @Test
    void outputRoundResultTest() {
        RoundDto roundResult = new RoundDto(List.of(
                new CarDto("pobi", 1), new CarDto("woni", 0), new CarDto("jun", 1)));
        String expected = """
                pobi : -
                woni :\s
                jun : -
                """;

        outputView.outputRoundResult(roundResult);

        assertThat(writer.getOutputText()).contains(expected);
    }

    @Test
    void outputWinnerTest_whenWinAlone() {
        List<String> winners = List.of("pobi");
        String expected = "최종 우승자 : pobi";

        outputView.outputWinners(winners);

        assertThat(writer.getOutputText()).contains(expected);
    }

    @Test
    void outputWinnerTest_whenWinTogether() {
        List<String> winners = List.of("pobi", "jun");
        String expected = "최종 우승자 : pobi, jun";

        outputView.outputWinners(winners);

        assertThat(writer.getOutputText()).contains(expected);
    }
}
