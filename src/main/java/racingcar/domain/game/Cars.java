package racingcar.domain.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.Car;
import racingcar.error.ErrorMessages;
import racingcar.strategy.MoveStrategy;
import racingcar.view.CarStatusDTO;
import racingcar.domain.Constants;

public class Cars {

  private final List<Car> carList;

  public Cars(List<String> carNames, MoveStrategy moveStrategy) {
    validateNoDuplicateNames(carNames);
    this.carList = createCars(carNames, moveStrategy);
  }

  public void moveCars() {
    this.carList.forEach(Car::move);
  }

  public List<CarStatusDTO> getCarStatuses() {
    return this.carList.stream().map(Car::carStatusDTO).toList();
  }

  public List<String> findWinners() {
    int maxPosition = findMaxPosition();
    return this.carList.stream().filter(car -> car.isAtPosition(maxPosition)).map(Car::getNameValue)
        .toList();
  }

  private int findMaxPosition() {
    return this.carList.stream().mapToInt(Car::getPositionValue).max()
        .orElse(Constants.CAN_NOT_PLAY_COUNT);
  }

  private void validateNoDuplicateNames(List<String> carNames) {
    Set<String> uniqueNames = new HashSet<>();
    carNames.forEach(name -> addUniqueName(uniqueNames, name.trim()));
  }

  private void addUniqueName(Set<String> uniqueNames, String name) {
    if (!uniqueNames.add(name.toLowerCase())) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_DUPLICATE.getMessage());
    }
  }

  public static List<Car> createCars(List<String> carNames, MoveStrategy moveStrategy) {
    return carNames.stream().map(String::trim).map(name -> new Car(name, moveStrategy)).toList();
  }
}
