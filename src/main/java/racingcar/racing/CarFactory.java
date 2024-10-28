package racingcar.racing;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> createRacingCars(String carNames) {
        String[] carName = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carName) {
            cars.add(new Car(name.trim()));
        }

        return cars;
    }
}
