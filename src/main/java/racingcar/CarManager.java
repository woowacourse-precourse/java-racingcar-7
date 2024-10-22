package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarManager {

    private final List<Car> list;

    public CarManager() {
        this.list = new ArrayList<>();
    }
    public void add(String carNames) {
        Arrays.stream(carNames.split(","))
                .map(Validator::validateNameLength)
                .map(Car::generateCars)
                .forEach(list::add);
    }

    public List<Car> getList() {
        return new ArrayList<>(list);
    }
}
