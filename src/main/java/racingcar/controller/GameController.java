package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class GameController {
    private final InputView inputView;
    private final ResultView resultView;

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    private Race initializeRace(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Race(cars);
    }
}
