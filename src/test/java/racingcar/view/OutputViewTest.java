package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;
import racingcar.dto.CarsPositionDto;
import racingcar.dto.WinnerNamesDto;

class OutputViewTest {

    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void cleanup() {
        System.setOut(originalOut);
    }

    @Test
    void 단일_라운드_결과를_출력한다() {
        // given
        List<CarsPositionDto> roundResults = List.of(
                new CarsPositionDto(List.of(
                        new CarPositionDto("pobi", 1),
                        new CarPositionDto("woni", 0)
                ))
        );

        // when
        outputView.printRoundResults(roundResults);
        String output = outputStream.toString();

        // then
        assertThat(output).contains(
                "실행 결과:",
                "pobi : -",
                "woni : "
        );
    }

    @Test
    void 여러_라운드_결과를_출력한다() {
        // given
        List<CarsPositionDto> roundResults = List.of(
                new CarsPositionDto(List.of(
                        new CarPositionDto("pobi", 1),
                        new CarPositionDto("woni", 0)
                )),
                new CarsPositionDto(List.of(
                        new CarPositionDto("pobi", 2),
                        new CarPositionDto("woni", 1)
                ))
        );

        // when
        outputView.printRoundResults(roundResults);
        String output = outputStream.toString();

        // then
        assertThat(output).contains(
                "실행 결과:",
                "pobi : -",
                "woni : ",
                "pobi : --",
                "woni : -"
        );
    }

    @Test
    void 긴_이동거리를_출력한다() {
        // given
        List<CarsPositionDto> roundResults = List.of(
                new CarsPositionDto(List.of(
                        new CarPositionDto("pobi", 5)
                ))
        );

        // when
        outputView.printRoundResults(roundResults);
        String output = outputStream.toString();

        // then
        assertThat(output).contains("pobi : -----");
    }

    @Test
    void 단일_우승자를_출력한다() {
        // given
        WinnerNamesDto winners = new WinnerNamesDto(List.of("pobi"));

        // when
        outputView.printWinners(winners);
        String output = outputStream.toString();

        // then
        assertThat(output).contains("최종 우승자 : pobi");
    }

    @Test
    void 공동_우승자를_출력한다() {
        // given
        WinnerNamesDto winners = new WinnerNamesDto(List.of("pobi", "woni"));

        // when
        outputView.printWinners(winners);
        String output = outputStream.toString();

        // then
        assertThat(output).contains("최종 우승자 : pobi, woni");
    }

    @Test
    void 이동거리가_0인_경우를_출력한다() {
        // given
        List<CarsPositionDto> roundResults = List.of(
                new CarsPositionDto(List.of(
                        new CarPositionDto("pobi", 0)
                ))
        );

        // when
        outputView.printRoundResults(roundResults);
        String output = outputStream.toString();

        // then
        assertThat(output).contains(
                "실행 결과:",
                "pobi : "
        );
    }

    @Test
    void 여러명의_참가자_결과를_출력한다() {
        // given
        List<CarsPositionDto> roundResults = List.of(
                new CarsPositionDto(List.of(
                        new CarPositionDto("pobi", 1),
                        new CarPositionDto("woni", 2),
                        new CarPositionDto("jun", 3)
                ))
        );

        // when
        outputView.printRoundResults(roundResults);
        String output = outputStream.toString();

        // then
        assertThat(output).contains(
                "실행 결과:",
                "pobi : -",
                "woni : --",
                "jun : ---"
        );
    }

    @Test
    void 빈_라운드_결과를_출력한다() {
        // given
        List<CarsPositionDto> roundResults = List.of(
                new CarsPositionDto(List.of())
        );

        // when
        outputView.printRoundResults(roundResults);
        String output = outputStream.toString();

        // then
        assertThat(output).contains("실행 결과:");
    }
}
