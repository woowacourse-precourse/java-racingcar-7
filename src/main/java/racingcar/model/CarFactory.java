package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.generator.NumberGenerator;

public class CarFactory {

    private final NumberGenerator numberGenerator;
    private final List<String> names;
    private final List<Car> cars;

    public CarFactory(List<String> names, NumberGenerator numberGenerator) {
        this.names = names;
        this.numberGenerator = numberGenerator;
        this.cars = makeCars();
    }

    private List<Car> makeCars() {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, numberGenerator));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
