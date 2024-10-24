package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingCar;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public void start() {
        String nameString = InputView.getCarNames();
        List<String> carNames = InputParser.nameParse(nameString);

        String numberString = InputView.getTryNumber();
        int tryNumber = InputParser.tryNumberParse(numberString);

        Cars cars = new Cars(carNames);
        RacingCar racingCar = new RacingCar(tryNumber, cars);
        Cars carsAfterRace = racingCar.race();
        String winners = racingCar.calculateFinalWinner(carsAfterRace);

        OutputView.showFinalWinner(winners);
    }

}
