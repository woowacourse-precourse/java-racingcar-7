package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.validator.CarValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGameController {
    public void startGame() {
        String[] carNames = InputView.getCarNames();
        String attempts = InputView.getRaceAttempts();
        CarValidator.validateAttempts(attempts);
        int attemptCount = Integer.parseInt(attempts);

        List<Car> cars = createCars(carNames);
        RacingGame game = new RacingGame(cars);

        runRounds(game, attemptCount);
        List<String> winners = determineWinners(game.getCars());
        OutputView.printFinalWinners(winners);
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        Set<String> existingNames = new HashSet<>();

        for (String name : carNames) {
            String trimmedName = name.trim();
            CarValidator.validateCarName(trimmedName, existingNames);
            cars.add(new Car(trimmedName));
        }
        return cars;
    }

    private void runRounds(RacingGame game, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            game.playRound();
            OutputView.printRoundResult(game);
        }
    }

    private List<String> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
