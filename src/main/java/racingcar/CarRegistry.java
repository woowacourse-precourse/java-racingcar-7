package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CarRegistry {
    private final Set<Car> cars;

    public CarRegistry(String input) {
        this.cars = convertInputToCarSet(input);
    }

    private Set<Car> convertInputToCarSet(String input) {
        Set<Car> cars = new HashSet<>();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(createCar(carName));
        }
        return cars;
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    public Set<Car> getCars() {
        return cars;
    }
}
