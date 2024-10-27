package racingcar.factory;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.strategy.MoveStrategy;

public class CarFactory {

  private CarFactory() {
  }

  public static List<Car> createCars(String[] carNames, MoveStrategy moveStrategy) {
    List<Car> cars = new ArrayList<>();
    for (String name : carNames) {
      Car car = new Car(name.trim(), moveStrategy);
      cars.add(car);
    }
    return cars;
  }
}
