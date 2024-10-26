package racingcar.domain;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.RandomMoveCondition;

public class Cars {
  private final List<Car> cars;

  public Cars(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Error: 입력값은 비어있을 수 없습니다.");
    }

    this.cars = new ArrayList<>();
    Set<String> carNames = new HashSet<>();

    String[] carNamesArray = input.split(",");
    for (String name : carNamesArray) {
      String trimmedName = name.trim();
      if (!carNames.add(trimmedName)) {
        throw new IllegalArgumentException("Error: 중복된 자동차 이름은 허용되지 않습니다.");
      }
      cars.add(new Car(trimmedName));
    }
  }

  public void moveCars() {
    for (Car car : cars) {
      if (RandomMoveCondition.isMovable()) {
        car.move();
      }
    }
  }

  public List<String> getAllCarStatuses() {
    return cars.stream()
        .map(car -> String.format("%s : %s", car.getName(), "-".repeat(car.getPosition())))
        .toList();
  }

  public List<String> findWinners() {
    int maxPosition = findMaxPosition();

    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .toList();
  }

  private int findMaxPosition() {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
  }
  public boolean contains(Car car) {
    return cars.contains(car);
  }

  public int size() {
    return cars.size();
  }
}