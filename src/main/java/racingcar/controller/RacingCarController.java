package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingCar;

public class RacingCarController {
    public String start(Cars cars, int tryNumber) {
        RacingCar racingCar = new RacingCar(tryNumber, cars);
        Cars carsAfterRace = racingCar.race();
        return racingCar.calculateFinalWinner(carsAfterRace);
    }
}
