package racingcar.domain.car;

import java.util.Comparator;

public class Car {
  private CarState state;
  private final CarService service;

  public static Comparator<Car> positionComparatorDesc = (car1, car2) -> Integer.compare(car2.state.position,
          car1.state.position);


  public Car(String name) {
    this.state = new CarState(name);
    this.service = new CarService();
  }

  public void stepForward() {
    if (service.canMoveForward()) {
      CarState _state = new CarState(this.state.name, this.state.position + 1);
      setState(_state);
    }
  }

  public CarState getState() {
    return new CarState(this.state);
  }

  public int getPosition() {
    return this.state.position;
  }

  public String getName() {
    return this.state.name;
  }

  private void setState(CarState state) {
    this.state = state;
  }

}
