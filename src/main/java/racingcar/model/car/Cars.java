package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private List<Car> cars;

  public Cars(List<String> carNames) {
    cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
  }

  public void startRacingCars() {
    for (Car car : cars) {
      car.moveCar();
    }
  }



}
