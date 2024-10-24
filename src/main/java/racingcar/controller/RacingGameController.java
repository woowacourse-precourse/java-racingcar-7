package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
  public void run() {
    String[] carNames = InputView.inputCarNames();
    int trialCount = InputView.inputTrialCount();

    List<Car> cars = createCars(carNames);

    for (int i = 0; i < trialCount; i++) {
      playRound(cars);
      ResultView.printRoundResult(cars);
    }

    List<Car> winners = findWinners(cars);
    ResultView.printWinners(winners);
  }

  private List<Car> createCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }

  private void playRound(List<Car> cars) {
    for (Car car : cars) {
      car.move();
    }
  }

  private List<Car> findWinners(List<Car> cars) {
    int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

    List<Car> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car);
      }
    }
    return winners;
  }
}
