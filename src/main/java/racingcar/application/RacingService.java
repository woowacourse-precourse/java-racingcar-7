package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;
import racingcar.domain.dto.CarDTO;

public class RacingService {

  public void moveCars(List<Car> cars) {
    cars.forEach(car -> car.tryToMove(generateRandomNumber()));
  }

  private int generateRandomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public List<CarDTO> getCarDTOs(List<Car> cars) {
    return cars.stream().map(Car::toDTO).toList();
  }

  public List<CarDTO> findWinners(List<CarDTO> carDTOs) {
    int maxPosition = carDTOs.stream().mapToInt(car -> car.positionDTO().position()).max()
        .orElse(0);

    return carDTOs.stream().filter(car -> car.positionDTO().position() == maxPosition).toList();
  }
}
