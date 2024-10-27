package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarStatusDTO;
import racingcar.util.Constants;

public class Cars {

  private final List<Car> carList;

  public Cars(List<Car> carList) {
    this.carList = carList;
  }

  public void moveCars() {
    for (Car car : this.carList) {
      car.move();
    }
  }

  public List<CarStatusDTO> getCarStatuses() {
    return this.carList.stream()
        .map(Car::carStatusDTO)
        .collect(Collectors.toList());
  }

  public List<String> findWinners() {
    int maxPosition = findMaxPosition();
    return this.carList.stream()
        .filter(car -> car.isAtPosition(maxPosition))
        .map(Car::getNameValue)
        .collect(Collectors.toList());
  }

  private int findMaxPosition() {
    return this.carList.stream()
        .mapToInt(Car::getPositionValue)
        .max()
        .orElse(Constants.CAN_NOT_PLAY_COUNT);
  }
}
