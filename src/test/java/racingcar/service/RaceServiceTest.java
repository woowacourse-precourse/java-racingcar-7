package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.constant.RegisterCarNumberConstant.PRIME_CAR_DISTANCE;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;

class RaceServiceTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 2;

    GameService gameService = new GameService();

    @Test
    void race() {
        List<Car> carList = List.of(
                new Car("BMW", PRIME_CAR_DISTANCE.getValue()),
                new Car("Audi", PRIME_CAR_DISTANCE.getValue())
        );

        Cars cars = new Cars(carList);
        assertRandomNumberInRangeTest(
                () -> {
                    Cars results = cars.moveOneTurn(gameService);
                    assertThat(results.carsToString()).contains("BMW : -", "Audi : ");
                },
                MOVING_FORWARD, STOP
        );
    }
}