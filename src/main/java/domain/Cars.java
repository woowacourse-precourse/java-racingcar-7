package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public static void raceOnce(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move();
        }
    }
}
