package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.service.dto.CarMoveRespDto;
import racingcar.car.service.dto.WinnerRespDto;

public class OutputViewTest {
    private OutputView outputView = OutputView.getInstance();
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("차수별 실행 결과를 출력한다.")
    public void printMoveResult() {
        // GIVEN
        System.setOut(new PrintStream(outputStream));
        CarMoveRespDto car1 = new CarMoveRespDto("car1", 1);
        CarMoveRespDto car2 = new CarMoveRespDto("car2", 2);

        // WHEN
        outputView.printMoveResults(List.of(car1, car2));

        // THEN
        assertThat(outputStream.toString()).contains("car1 : -", "car2 : --");
    }

    @Test
    @DisplayName("우승자를 출력한다.")
    public void printWinner() {
        // GIVEN
        WinnerRespDto winner1 = new WinnerRespDto("car1");
        WinnerRespDto winner2 = new WinnerRespDto("car2");
        WinnerRespDto winner3 = new WinnerRespDto("car3");

        // WHEN
        outputView.printWinners(List.of(winner1, winner2, winner3));

        // THEN
        assertThat(outputStream.toString()).contains("최종 우승자 : car1, car2, car3");
    }
}
