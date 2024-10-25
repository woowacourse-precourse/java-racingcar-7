package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> carList = new ArrayList<>();

    public void createCars(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(carList::add);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
