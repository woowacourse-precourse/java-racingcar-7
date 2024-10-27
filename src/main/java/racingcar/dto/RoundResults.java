package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RoundResults {
    private final List<List<Car>> results = new ArrayList<>();

    public void saveResult(List<Car> cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new Car(car.getCarName(), car.getPosition()));
        }
        results.add(result);
    }

    public List<List<Car>> getResult() {
        return results;
    }
}
