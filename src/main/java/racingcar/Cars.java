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

    public List<List<Car>> race(int raceTime) {
        List<List<Car>> racingRecords = new ArrayList<>();
        racingRecords.add(this.cars);

        for (int i = 0; i < raceTime; i++) {
            List<Car> racingCars = moveCars(racingRecords.get(i));
            racingRecords.add(racingCars);
        }

        return racingRecords.subList(1, racingRecords.size());
    }

    public Map<String, Boolean> matchCarNames(List<String> carNames) {
        Map<String, Boolean> carNamesMatchResult = new HashMap<>();

        int maxSize = Math.max(carNames.size(), this.cars.size());
        for (int i = 0; i < maxSize; i++) {
            carNamesMatchResult.put(carNames.get(i), this.cars.get(i).isName(carNames.get(i)));
        }

        return carNamesMatchResult;
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private List<Car> moveCars(List<Car> cars) {
        List<Car> movingCars = new ArrayList<>();

        for (Car car : cars) {
            movingCars.add(car.move());
        }

        return movingCars;
    }
}
