package racingcar.domain;

import racingcar.dto.CarStatusDTO;
import racingcar.strategy.MoveStrategy;

public class Car {

  private final CarName name;
  private final Position position = new Position();
  private final MoveStrategy moveStrategy;

  public Car(String name, MoveStrategy moveStrategy) {
    this.name = new CarName(name);
    this.moveStrategy = moveStrategy;
  }

  public void move() {
    if (this.moveStrategy.isMovable()) {
      this.position.increase();
    }
  }

  public boolean isAtPosition(int targetPosition) {
    return this.position.isEqualTo(targetPosition);
  }

  public String getNameValue() {
    return this.name.value();
  }

  public int getPositionValue() {
    return this.position.getValue();
  }

  public CarStatusDTO carStatusDTO() {
    return new CarStatusDTO(this.name.value(), this.position.getValue());
  }
}
