package racingcar.application.service;

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
}
