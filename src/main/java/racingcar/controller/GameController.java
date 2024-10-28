package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    
    public void run() {
        List<Car> cars = createCars();
        int attemptCount = InputView.getAttemptCount();

        Game game = new Game(cars, attemptCount);
        game.start();

        OutputView.printWinners(game.getWinners());
    }

    private List<Car> createCars() {
        List<String> carNames = InputView.getCarNames();
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
