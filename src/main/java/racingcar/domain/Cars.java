package racingcar.domain;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.error.ErrorMessages;
import racingcar.util.RandomMoveCondition;

public class Cars {

  private static final String DELIMITER = ",";
  private static final String STATUS_FORMAT = "%s : %s";
  private static final String POSITION_SYMBOL = "-";
  private final List<Car> cars;

  public Cars(String input) {
    validateInput(input);
    this.cars = parseCarNames(input);
  }

  public void moveCars() {
    cars.forEach(car -> {
      if (RandomMoveCondition.isMovable()) {
        car.move();
      }
    });
  }

  public List<String> getAllCarStatuses() {
    return cars.stream()
        .map(car -> String.format(STATUS_FORMAT, car.getName(),
            POSITION_SYMBOL.repeat(car.getPosition())))
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

  private void validateInput(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.INPUT_EMPTY);
    }
  }

  private List<Car> parseCarNames(String input) {
    String[] carNamesArray = input.split(DELIMITER);
    Set<String> uniqueNames = validateUniqueNames(carNamesArray);
    return createCarList(uniqueNames);
  }

  private Set<String> validateUniqueNames(String[] carNamesArray) {
    Set<String> uniqueNames = new HashSet<>();
    for (String name : carNamesArray) {
      String trimmedName = name.trim();
      if (!uniqueNames.add(trimmedName)) {
        throw new IllegalArgumentException(ErrorMessages.CAR_NAME_DUPLICATE);
      }
    }
    return uniqueNames;
  }

  private List<Car> createCarList(Set<String> uniqueNames) {
    List<Car> carList = new ArrayList<>();
    for (String name : uniqueNames) {
      carList.add(new Car(name));
    }
    return carList;
  }
}