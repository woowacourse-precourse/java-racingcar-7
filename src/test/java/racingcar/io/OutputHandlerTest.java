package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCars;

class OutputHandlerTest extends IOTest {
    private final OutputHandler outputHandler = new OutputHandler();

    @DisplayName("실행 결과 문자열을 포함해 출력한다")
    @Test
    void showGameResult() {
        // given
        String gameResult = "test";

        // when
        outputHandler.showGameResult(gameResult);

        // then
        assertThat(output()).contains("실행결과\ntest");
    }

    @DisplayName("우승자들을 ,로 합쳐 출력한다")
    @Test
    void showWinners() {
        // given
        RacingCars racingCars = RacingCars.fromNames(List.of("car1", "car2"));

        // when
        outputHandler.showWinners(racingCars);

        // then
        assertThat(output()).contains("최종 우승자 : car1, car2");
    }


}