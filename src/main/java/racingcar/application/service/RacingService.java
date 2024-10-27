package racingcar.application.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.application.dto.InputCarNamesDTO;
import racingcar.application.model.Car;

public class RacingService {

  private int attemptCount;
  private List<Car> cars;

  public void setup(String inputCarNames, int inputAttemptCount) {

    InputCarNamesDTO inputCarNamesDTO = new InputCarNamesDTO(inputCarNames);
    cars = inputCarNamesDTO.toModel();

    this.attemptCount = inputAttemptCount;
  }

  public List<Car> playRound() {

    for (Car car : cars) {
      if (randomNumber() >= 4) {
        car.move();
      }
    }

    return cars;
  }

  private int randomNumber() {
    return Randoms.pickNumberInRange(0, 9);
  }

  public int getAttemptCount() {
    return attemptCount;
  }
}
