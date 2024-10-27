package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.validator.CarValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    public void startGame() {
        String[] carNames = InputView.getCarNames();
        int attempts = InputView.getRaceAttempts();

        // Validate attempts
        CarValidator.validateAttempts(attempts);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            CarValidator.validateCarName(trimmedName);
            cars.add(new Car(trimmedName));
        }

        RacingGame game = new RacingGame(cars);

        for (int i = 0; i < attempts; i++) {
            game.playRound();
            OutputView.printRoundResult(game);
        }
    }
}
