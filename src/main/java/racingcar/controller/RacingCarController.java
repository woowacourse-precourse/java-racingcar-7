package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.RaceCars;

public class RacingCarController {
    public void run(){
        List<String> carNames = InputView.readCarNames();
        int count = InputView.readCount();
        List<Car> winnerCars = RaceCars.race(carNames, count);
        OutputView.printWinners(winnerCars);
    }
}
