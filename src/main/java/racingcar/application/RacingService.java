package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

  public void moveCars(List<Car> cars) {
    cars.forEach(car -> car.tryToMove(generateRandomNumber()));
  }

  private int generateRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public List<Car> findWinners(List<Car> cars) {
    int maxPosition = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);

    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .collect(Collectors.toList());
  }
}
