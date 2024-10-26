package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        makeCarListWithNames(carNames);
    }

    private void makeCarListWithNames(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(makeCar(carName));
        }
    }

    private Car makeCar(String name) {
        return new Car(name);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
