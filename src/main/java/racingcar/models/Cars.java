package racingcar.models;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new ArrayList<>();
        addToCars(carNames);
    }

    private void addToCars(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName.trim()));
        }
    }

}