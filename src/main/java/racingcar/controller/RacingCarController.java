package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingCar;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public String start(List<String> carNames, int tryNumber) {
        Cars cars = new Cars(carNames);
        RacingCar racingCar = new RacingCar(tryNumber, cars);
        Cars carsAfterRace = racingCar.race();
        return racingCar.calculateFinalWinner(carsAfterRace);
    }
}
