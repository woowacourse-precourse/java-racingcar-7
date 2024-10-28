package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        validateUniqueCarNames(carNames);

        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void foward() {
        for (Car car : cars) {
            car.foward();
        }
    }

    public List<String> getWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateUniqueCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 값 입니다.");
        }

        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름 입력은 불가능 합니다.");
        }
    }
}
