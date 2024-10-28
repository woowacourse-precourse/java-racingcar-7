package racingcar.domain;

import racingcar.domain.dto.CarDTO;

public class Car {

  private final String name;
  private final Position position;

  public Car(String name) {
    this.name = name;
    this.position = new Position();
  }

  public void tryToMove(int randomValue) {
    if (randomValue >= 4) {
      position.move();
    }
  }

  public CarDTO toDTO() {
    return new CarDTO(name, position.toDTO());
  }
}
