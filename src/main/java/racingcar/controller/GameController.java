package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void startGame() {
        String[] carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();
        Race race = new Race(cars);

        for (int i = 0; i < tryCount; i++) {
            race.proceedRound();
            OutputView.printRoundResult(cars);
        }

        OutputView.printWinners(race.getWinners());
    }

}

