package racingcar.application.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.application.model.Car;

public class InputCarNamesDTO {

  private final String carNames;

  public InputCarNamesDTO(String carNames) {
    this.carNames = carNames;
  }

  public List<Car> toModel() {
    return Stream.of(carNames.split(","))
        .map(String::trim)
        .map(Car::new)
        .collect(Collectors.toList());
  }
}
