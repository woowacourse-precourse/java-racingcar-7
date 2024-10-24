package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final Set<Car> carStore;

    private Cars(List<Car> cars) {
        Set<Car> carStore = new LinkedHashSet<>(cars);
        if (cars.size() != carStore.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
        this.carStore = carStore;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Cars(cars);
    }

    public void moveAll() {
        carStore.forEach(Car::move);
    }

    public List<CarDetail> getAllCarDetails() {
        return carStore.stream()
                .map(Car::getCarDetail)
                .toList();
    }

    public List<CarDetail> getVictoryCarNames() {
        List<Car> cars = new ArrayList<>(carStore);
        cars.sort(Collections.reverseOrder());
        Car largestCar = cars.get(0); // 가장 큰 요소
        return cars.stream()
                .filter(car -> car.compareTo(largestCar) == 0)
                .map(Car::getCarDetail)
                .toList();

    }
}
