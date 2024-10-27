package racingcar.domain.car;

import java.util.List;

public class CarFactory {

    public Cars makeCars(List<String> carNames) {
      Cars cars = new Cars();
      for(String carName : carNames) {
          Car car = makeCar(carName);
          cars.registerCar(car);
      }
      return cars;
    }

    private Car makeCar(String carName) {
        return new Car(carName);
    }
}
