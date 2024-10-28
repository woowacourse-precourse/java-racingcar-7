package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class WinnerServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("많이 전진한 차를 우승자로 결정")
    @Test
    void decideWinnerBasedOnMaxPosition() {
        String carNames = "pobi,woni,jun";
        RegisterService registerService = new RegisterService();
        Cars cars = registerService.registerCars(carNames);

        RoundService roundService = new RoundService();
        WinnerService winnerService = new WinnerService();

        assertRandomNumberInRangeTest(
                () -> {
                    roundService.playRound(cars);
                },
                MOVING_FORWARD, STOP, STOP
        );

        List<Car> winners = winnerService.getWinners(cars);
        assertThat(winners)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi");
    }

    @DisplayName("많이 전진한 차들을 우승자로 결정")
    @Test
    void decideWinnersBasedOnMaxPosition() {
        String carNames = "pobi,woni,jun";
        RegisterService registerService = new RegisterService();
        Cars cars = registerService.registerCars(carNames);

        RoundService roundService = new RoundService();
        WinnerService winnerService = new WinnerService();

        assertRandomNumberInRangeTest(
                () -> {
                    roundService.playRound(cars);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );

        List<Car> winners = winnerService.getWinners(cars);
        assertThat(winners)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "woni");
    }

}
