package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarsManager {

    private final List<Car> cars;

    public CarsManager(List<Car> cars) {
        this.cars = cars;
    }

   public static CarsManager by(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new CarsManager(cars);
   }
}
