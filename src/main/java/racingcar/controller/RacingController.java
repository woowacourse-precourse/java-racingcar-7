package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    public void startRace() {
        List<String> carName = InputView.carNameInput();
        int moveCount = InputView.moveCountInput();

        List<Car> cars = carName.stream()
                            .map(Car::new)
                            .toList();

        Race race = new Race(cars, moveCount);
        race.startRace();

        OutputView.printProgress(cars);
        OutputView.printWinner(race.getWinners());

    }
}
