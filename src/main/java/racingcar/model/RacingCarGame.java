package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public record RacingCarGame(List<Car> cars) {

  public void play() {
    cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
  }

  public List<String> getWinners() {
    return cars.stream()
            .filter(car -> car.getMoveCount() == getMaxPosition())
            .map(Car::getCarName)
            .toList();
  }

  private int getMaxPosition() {
    int maxPosition = cars.stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대값을 찾을 수 없습니다."));

    if (maxPosition == 0) {
      throw new IllegalArgumentException("최대값이 0이어선 안됩니다.");
    }
    return maxPosition;
  }
}
