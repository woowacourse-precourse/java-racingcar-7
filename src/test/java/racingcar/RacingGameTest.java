package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceRound;

public class RacingGameTest {
    private static final String CAR_NAMES = "emily, tomas, gina";
    private static final String NUMBER_OF_ROUNDS = "2";
    private RacingGameController controller;

    @Test
    void 자동차_이동_테스트(){
        controller = new RacingGameController();
        Car car = new Car("gina", 1);

        car.moveIfTrue( 5);

        assertEquals(5, car.getDistance().getDistanceValue());
    }

    @Test
    void 자동차_이동안함_테스트(){
        controller = new RacingGameController();
        Car car = new Car("gina", 1);

        car.moveIfTrue( 3);

        assertEquals(0, car.getDistance().getDistanceValue());
    }
}
