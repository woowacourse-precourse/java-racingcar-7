package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    public void start() {
        List<Car> cars = initializeCars();
        int trialCount = InputView.getTrialCount();

        RacingGame racingGame = new RacingGame(cars);

        for (int i = 0; i < trialCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(cars);
        }

        List<String> winners = findWinners(cars);
        OutputView.printWinners(winners);
    }

    private List<Car> initializeCars() {
        List<String> carNames = InputView.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<String> findWinners(List<Car> cars) {
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