package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    protected final List<Car> cars = new ArrayList<>();

    public Racing(List<String> cars) {
        cars.forEach(name -> this.cars.add(new Car(name)));
    }


}
