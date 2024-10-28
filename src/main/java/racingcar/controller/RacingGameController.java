package racingcar.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
  public void run() {
    String[] carNames = InputView.inputCarNames();
    int trialCount = InputView.inputTrialCount();

    validateCarNames(carNames);
    validateTrialCount(trialCount);

    List<Car> cars = createCars(carNames);

    for (int i = 0; i < trialCount; i++) {
      playRound(cars);
      ResultView.printRoundResult(cars);
    }

    List<Car> winners = findWinners(cars);
    ResultView.printWinners(winners);
  }
  private void validateCarNames(String[] carNames) {
    Set<String> uniqueNames = new HashSet<>();
    for (String name : carNames) {
      if (!uniqueNames.add(name)) {
        throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
      }
    }
  }

  private void validateTrialCount(int trialCount) {
    if (trialCount < 1) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
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
