package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public List<Car> moveCars() {
        List<Car> movingCars = new ArrayList<>();

        for (Car car : this.cars) {
            movingCars.add(car.move());
        }

        return movingCars;
    }

    public Map<String, Boolean> matchCarNames(List<String> carNames) {
        Map<String, Boolean> carNamesMatchResult = new HashMap<>();

        int minSize = Math.min(carNames.size(), this.cars.size());
        for (int i = 0; i < minSize; i++) {
            carNamesMatchResult.put(carNames.get(i), this.cars.get(i).isName(carNames.get(i)));
        }

        return carNamesMatchResult;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
