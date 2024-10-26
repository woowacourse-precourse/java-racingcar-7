package racingcar.io;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;

class OutputHandlerTest extends IOTest {
    private final OutputHandler outputHandler = new OutputHandler();

    @DisplayName("차량의 현재 진행상황을 출력한다.")
    @Test
    void showRacingCarsProgress() {
        // given
        RacingCar car1 = RacingCar.of("car1");
        RacingCar car2 = RacingCar.of("car2");

        car1.increaseMoveCount();
        car2.increaseMoveCount();

        List<RacingCar> racingCars = List.of(car1, car2);

        // when
        outputHandler.showRacingCarsProgress(racingCars);

        // then
        assertThat(output()).contains(
                "car1 : -",
                "car2 : -"
        );
    }

    @DisplayName("단독 우승자를 출력한다.")
    @Test
    void showWinner() {
        // given
        List<String> winner = List.of("car1");

        // when
        outputHandler.showWinners(winner);

        // then
        assertThat(output()).contains("car1");
    }

    @DisplayName("공동 우승자를 출력한다.")
    @Test
    void showWinners() {
        // given
        List<String> winners = List.of("car1, car2, car3");

        // when
        outputHandler.showWinners(winners);

        // then
        assertThat(output()).contains("car1, car2, car3");
    }
}