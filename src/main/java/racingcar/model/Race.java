package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class Race {
    private final List<Car> cars;

    public Race(List<String> names) {
        validateNames(names);
        this.cars = createCars(names);
    }

    private void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 목록이 비어있습니다.");
        }
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }

    public void playRound() {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(0, 9);
            car.move(number);
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}