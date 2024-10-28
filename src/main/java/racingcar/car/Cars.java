package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        validateDuplication(car);
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.isWinner(maxPosition))
            .map(Car::getName)
            .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    private void validateDuplication(Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }
}
