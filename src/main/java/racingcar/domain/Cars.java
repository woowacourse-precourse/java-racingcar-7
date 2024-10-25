package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MIN_CAR_LENGTH = 1;
    private static final int MAX_CAR_LENGTH = 100;
    private static final String CAR_LENGTH_ERROR_MESSAGE =
            String.format("자동차의 개수는 %d 이상 %d 이하여야 합니다.", MIN_CAR_LENGTH, MAX_CAR_LENGTH);

    private final Set<Car> carStore;

    private Cars(List<Car> cars) {
        Set<Car> carStore = new LinkedHashSet<>(cars);
        if (cars.size() != carStore.size()) {
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
        this.carStore = carStore;
    }

    public static Cars from(List<String> carNames) {
        validateCarNames(carNames);
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Cars(cars);
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.size() < MIN_CAR_LENGTH || carNames.size() > MAX_CAR_LENGTH) {
            throw new IllegalArgumentException(CAR_LENGTH_ERROR_MESSAGE);
        }
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
