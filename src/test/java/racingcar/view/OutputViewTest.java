package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarMovementResults;
import racingcar.model.CarStatus;

public class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputView = OutputView.getInstance();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("실행 결과 출력 시 의도한 형식대로 출력된다.")
    void shouldDisplayResultInExpectedFormat() {
        // given
        CarMovementResults carStatusesOfFirstAttempt = new CarMovementResults(List.of(
                new CarStatus("pobi", 3),
                new CarStatus("juni", 2)
        ));

        CarMovementResults carStatusesOfSecondAttempt = new CarMovementResults(List.of(
                new CarStatus("pobi", 4),
                new CarStatus("juni", 3)
        ));

        List<CarMovementResults> carMovementResults = List.of(
                carStatusesOfFirstAttempt, carStatusesOfSecondAttempt
        );

        // when
        outputView.displayMovementResults(carMovementResults);

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "실행 결과\npobi : ---\njuni : --\n\npobi : ----\njuni : ---\n\n");
    }

    @Test
    @DisplayName("우승자가 한 명인 경우 의도한 형식대로 출력된다.")
    void shouldDisplaySingleWinnerInExpectedFormat() {
        // given
        List<String> nameOfSingleWinner = List.of("pobi");

        // when
        outputView.displayWinners(nameOfSingleWinner);

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "최종 우승자 : pobi\n");
    }

    @Test
    @DisplayName("우승자가 여러명인 경우 의도한 형식대로 출력된다.")
    void shouldDisplayWinnersInExpectedFormat() {
        // given
        List<String> nameOfWinners = List.of("pobi", "jun");

        // when
        outputView.displayWinners(nameOfWinners);

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "최종 우승자 : pobi, jun\n");
    }
}
