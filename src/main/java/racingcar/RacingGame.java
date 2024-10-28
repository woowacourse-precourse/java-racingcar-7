package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
  private final List<Car> cars;
  private final int attempts;

  public RacingGame(List<String> carNames, int attempts) {
    validateAttempts(attempts);
    this.cars = createCars(carNames);
    this.attempts = attempts;
  }

  private void validateAttempts(int attempts) {
    if (attempts <= 0) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
  }

  private List<Car> createCars(List<String> carNames) {
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
    return cars;
  }

  public void startRace() {
    for (int i = 0; i < attempts; i++) {
      raceOnce();
      printRaceStatus();
    }
    printWinners();
  }

  private void raceOnce() {
    for (Car car : cars) {
      car.move(Randoms.pickNumberInRange(0, 9)); // 무작위 값으로 이동 결정
    }
  }

  private void printRaceStatus() {
    for (Car car : cars) {
      System.out.println(car.getName() + " : " + car.getPositionAsString());
    }
    System.out.println();
  }

  private void printWinners() {
    int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    List<String> winners = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());

    System.out.println("최종 우승자 : " + String.join(", ", winners));
  }
}
