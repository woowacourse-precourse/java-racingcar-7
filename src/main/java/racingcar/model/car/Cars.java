package racingcar.model.car;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carsNames) {
        cars = carsNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
