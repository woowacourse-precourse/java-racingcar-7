package racingcar.Service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RegisterService;
import racingcar.service.RoundService;

public class RoundServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @DisplayName("무작위 값이 4 이상이면 전진")
    @Test
    void forwardWhenRandomValueIsFourOrMore() {
        String carNames = "pobi";
        RegisterService registerService = new RegisterService();
        Cars cars = registerService.registerCars(carNames);

        Car car1 = cars.getCars().get(0);
        RoundService roundService = new RoundService();

        assertRandomNumberInRangeTest(
                () -> {
                    roundService.playRound(cars);  // playRound를 통해 이동 결정

                    assertEquals(1, car1.getPosition());
                },
                MOVING_FORWARD
        );
    }

    @DisplayName("무작위 값이 4 미만이면 정지")
    @Test
    void stopWhenRandomValueIsLessThanFour() {
        String carNames = "pobi";
        RegisterService registerService = new RegisterService();
        Cars cars = registerService.registerCars(carNames);

        Car car1 = cars.getCars().get(0);
        RoundService roundService = new RoundService();

        assertRandomNumberInRangeTest(
                () -> {
                    roundService.playRound(cars);  // playRound를 통해 이동 결정

                    assertEquals(0, car1.getPosition());
                },
                STOP
        );
    }
}
