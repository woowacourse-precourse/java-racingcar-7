package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto.CarOutputDto;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;

class ConsoleOutputViewTest {
    ConsoleOutputView consoleOutputView;
    OutputStream out;

    @BeforeEach
    void setUp() {
        consoleOutputView = new ConsoleOutputView();
        out = new ByteArrayOutputStream();
    }

    @Test
    void printOutputStart() {
        //given
        System.setOut(new PrintStream(out));

        //when
        consoleOutputView.printOutputStart();

        //then
        assertThat(out.toString())
                .contains("실행 결과");
    }

    @Test
    void printRacingHistoryByRound() {
        //given
        System.setOut(new PrintStream(out));
        List<RacingHistoryOutputDto> racingHistoryOutputDtoList = List.of(new RacingHistoryOutputDto("test", 2, 3));

        //when
        consoleOutputView.printRacingHistoryByRound(racingHistoryOutputDtoList);

        //then
        assertThat(out.toString())
                .contains("test : ---");
    }

    @Test
    void printWinner() {
        //given
        System.setOut(new PrintStream(out));
        List<CarOutputDto> winnerList = List.of(new CarOutputDto("test"));

        //when
        consoleOutputView.printWinner(winnerList);

        //then
        assertThat(out.toString())
                .contains("최종 우승자 : test");
    }
}
