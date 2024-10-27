package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Name;
import racingcar.model.Position;
import racingcar.model.dto.FinalResultDto;
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
                .isEqualTo(ViewMessage.RESULT_MESSAGE.getMessage() + "\n");
    }

    @Test
    @DisplayName("라운드 결과를 출력한다.")
    void printRoundResult() {
        //given
        Map<Name, Position> result = new LinkedHashMap<>();
        result.put(new Name("박재연"), new Position(2));
        result.put(new Name("우테코"), new Position(3));

        //when
        outputView.printRoundInformation(RoundResultDto.of(result));
        // then
        Assertions.assertThat(out.toString())
                .isEqualTo("박재연 : 2\n우테코 : 3\n");
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
                .isEqualTo(ViewMessage.WINNERS_MESSAGE.getMessage() + "우테코, 박재연\n");
    }

}