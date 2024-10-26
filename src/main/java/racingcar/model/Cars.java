package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars, String[] carNames) {
        makeCarListWithNames(cars, carNames);
        this.cars = cars;
    }

    private void makeCarListWithNames(List<Car> cars, String[] carNames) {
        for (String carName : carNames) {
            cars.add(makeCar(carName));
        }
    }

    private Car makeCar(String name) {
        return new Car(name);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
