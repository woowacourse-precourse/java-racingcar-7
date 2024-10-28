package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.FinalResultDto;
import racingcar.model.dto.RoundIndividualResultDto;
import racingcar.model.dto.RoundResultDto;

class OutputViewTest {
    OutputView outputView;
    OutputStream out;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("결과 안내문구를 출력한다.")
    void printResultGuide() {
        //when
        outputView.printResultMessage();

        //then
        Assertions.assertThat(out.toString())
                .isEqualTo("\n" + ViewMessage.RESULT_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("라운드 결과를 출력한다.")
    void printRoundResult() {
        //given
        RoundIndividualResultDto individual1 = new RoundIndividualResultDto("박재연", 2);
        RoundIndividualResultDto individual2 = new RoundIndividualResultDto("우테코", 3);
        RoundResultDto result = new RoundResultDto(Arrays.asList(individual1, individual2));

        //when
        outputView.printRoundResult(result);

        // then
        Assertions.assertThat(out.toString())
                .isEqualTo("\n박재연 : --\n우테코 : ---\n");
    }

    @Test
    @DisplayName("우승자를 출력한다.")
    void printWinners() {
        //given
        FinalResultDto result = new FinalResultDto(Arrays.asList("우테코", "박재연"));
        //when
        outputView.printWinners(result);
        // then
        Assertions.assertThat(out.toString())
                .isEqualTo("\n" + ViewMessage.WINNERS_MESSAGE.getMessage() + "우테코, 박재연");
    }
}